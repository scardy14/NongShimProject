package controller;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import member.NongShimMemberDAO;
import member.NongShimMemberVO;

public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id=request.getParameter("id");
		String password=request.getParameter("password");
		NongShimMemberVO mvo=NongShimMemberDAO.getInstance().login(id, password);
		String viewPath=null;
		if(mvo==null) {
			viewPath="login/login-fail.jsp"; 
		}else {
			viewPath="index.jsp";
			HttpSession session=request.getSession();
			session.setAttribute("mvo", mvo);
			
			//민석이가 조회수 기능을 위해 한줄 추가했습니다.
			session.setAttribute("hitboard", new ArrayList<Long>());
			
		}
		
		return viewPath;
	}

}
