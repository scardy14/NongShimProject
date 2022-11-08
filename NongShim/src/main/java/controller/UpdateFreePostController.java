package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FreePostDAO;
import model.FreePostVO;

public class UpdateFreePostController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long post_No = Long.parseLong(request.getParameter("post_No"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		FreePostVO freepostVO = new FreePostVO(post_No, title, content);
		FreePostDAO.getInstance().updatePost(freepostVO);
		return "redirect:FindFreePostListController.do";
	}

}
