package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductPostDAO;

public class DeletePostController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String no=request.getParameter("no");
		ProductPostDAO.getInstance().deletePost(Long.parseLong(no));
		return "redirect:FindPostListByValueController.do";
	}
}
