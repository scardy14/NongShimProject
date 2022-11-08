package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FreePostDAO;
import model.FreePostVO;

public class UpdateFreePostFormControllerMove implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long no=Long.parseLong(request.getParameter("no"));
		FreePostVO freepostVO = FreePostDAO.getInstance().findPostDetail(no);
		request.setAttribute("freepostvo", freepostVO);
		request.setAttribute("url","freeboard/update-form.jsp");
		return "mainpage.jsp";
	}
}
