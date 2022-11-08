package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FreePostDAO;

public class DeleteFreePostController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long no=Long.parseLong(request.getParameter("post_No"));
		System.out.println(no);
		FreePostDAO.getInstance().deletePost(no);
		return "redirect:FindFreePostListController.do";
	}

}
