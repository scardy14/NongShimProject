package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductPostDAO;
import model.ProductPostVO;

public class DeletePostController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		long no=Long.parseLong(request.getParameter("no"));
		 ProductPostDAO.getInstance().deletePost(no);

		return "redirect:FindPostListByValueController.do";
	}
}
