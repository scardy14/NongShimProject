package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductPostDAO;

public class UpdateProductPostCommentController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long comment_No = Long.parseLong(request.getParameter("comment_No"));
		Long post_No = Long.parseLong(request.getParameter("post_No"));
		String content = request.getParameter("content");
		ProductPostDAO dao = ProductPostDAO.getInstance();
		dao.updateComment(comment_No, content);
		return "redirect:ProductDetailController.do?postno="+post_No;
	}

}
