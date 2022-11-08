package controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductPostDAO;

public class DeleteProductPostCommentController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long comment_No = Long.parseLong(request.getParameter("comment_No"));
		String postNo = request.getParameter("post_No");
		ProductPostDAO dao =ProductPostDAO.getInstance();
		dao.deleteComment(comment_No);
		return "redirect:ProductDetailController.do?postno="+postNo;
	}

}

