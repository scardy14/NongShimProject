package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FreePostDAO;
import model.FreePostVO;

public class UpdateFreePostFormControllerMove implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FreePostDAO freepostDAO = FreePostDAO.getInstance();
		long post_No=Long.parseLong(request.getParameter("post_No"));
		FreePostVO freepostVO = freepostDAO.findPostDetail(post_No);
		request.setAttribute("freepostvo", freepostVO);
		request.setAttribute("url","freeboard/update-form.jsp");
		return "mainpage.jsp";
	}
}
