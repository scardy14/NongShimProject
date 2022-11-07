package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductPostDAO;
import model.ProductPostVO;

public class DeletePostController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long no=Long.parseLong(request.getParameter("no"));
		System.out.println(no);
		 ProductPostDAO.getInstance().deletePost(no);

		return "redirect:FindPostListByValueController.do";
	}
}
