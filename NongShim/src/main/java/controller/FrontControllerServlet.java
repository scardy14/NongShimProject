package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Front Controller Design Pattern : 클라이언트의 요청을 하나의 진입점으로 모아서 처리
 * 										 공통 정책 ( 인코딩 , 예외처리 , 인증 등 .. ) 을 효과적으로 처리할 수 있다
 * 										 ( ex- 은행 콜센터 , 키오스크 )    
 */
@WebServlet("*.do")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;  
    protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String servletPath=request.getServletPath();
			String controllerName=servletPath.substring(1, servletPath.length()-3);
			//System.out.println(getServletName()+" controllerName:"+controllerName);
			Controller controller=HandlerMapping.getInstance().create(controllerName);
			//System.out.println(getServletName()+" 개별 컨트롤러 구현체:"+controller);
			// Controller interface 로 캡슐화, 계층구조 형성하였으므로 다양한 하위 컨트롤러 객체들을 
			// 단일한 소통방식으로 제어할 수 있다 -> 다형성 지원 
			String viewPath=controller.handleRequest(request,response);
			if(viewPath.startsWith("redirect:")) { // redirect 방식으로 응답 ( 기존 request,response 유지 x )
				response.sendRedirect(viewPath.substring(9));
			}else { // forward 방식으로 응답 ( 기존 request, response 유지 0 ) 
				request.getRequestDispatcher(viewPath).forward(request, response);
			}
		}catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDispatch(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doDispatch(request, response);
	}
}







