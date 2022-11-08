package controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductPostDAO;

public class DeleteProductPostCommentController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String comment = request.getParameter("comment");
		String date = request.getParameter("date");
		System.out.println(date);
		long postNo = Long.parseLong(request.getParameter("postNo"));
		ProductPostDAO dao =ProductPostDAO.getInstance();
		dao.deleteComment(id, postNo, comment);
		return "index.jsp";
	}

}

