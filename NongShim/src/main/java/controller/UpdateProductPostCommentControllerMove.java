package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CommentVO;
import model.ProductPostDAO;

public class UpdateProductPostCommentControllerMove implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long comment_No = Long.parseLong(request.getParameter("comment_No"));
		ProductPostDAO dao = ProductPostDAO.getInstance();
		CommentVO commentVO = dao.FindCommentByPostNo(comment_No);
		request.setAttribute("commentVO", commentVO);
		request.setAttribute("url", "productboard/updatecommentform.jsp");
		return "mainpage.jsp";
	}
}