package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ProductPostDAO;

public class MoonCommentController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		
		
		
		
		//민석 여기서 id 자리에 스프링 고정하는게 아니라 세션에서 아이디를 받아오고싶음. 근데 기억안남!!!!!!!!!!!
		
		
		
		
		
		
		
		
		
		//HttpSession session=request.getSession(false);
		//String id1=session.getAttribute("mvo").
		String id ="spring"; //여기부분 세션에서 받아와야함 일단 임시로 아무거나 넣어둠.
		long no=Long.parseLong(request.getParameter("postno"));
		String comment= request.getParameter("comment");
		
		
		ProductPostDAO.getInstance().addCommentInMoon(id, no, comment);
		//request.setAttribute("url", "ProductDetailController");
		return "ProductDetailController.do";
	}

}
