package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductPostDAO;

public class HooCommentController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id ="spring"; //여기부분 세션에서 받아와야함 일단 임시로 아무거나 넣어둠.
		long no=Long.parseLong(request.getParameter("postno"));
		String comment= request.getParameter("comment");
		
		
		ProductPostDAO.getInstance().addCommentInHoo(id, no, comment);
		//request.setAttribute("url", "ProductDetailController");
		return "ProductDetailController.do";
		
	}

}
