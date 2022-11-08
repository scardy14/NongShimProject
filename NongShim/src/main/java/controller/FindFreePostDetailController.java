package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FreePostDAO;

public class FindFreePostDetailController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FreePostDAO freepostDAO = FreePostDAO.getInstance();
		String post_No=request.getParameter("post_No");
		request.setAttribute("FreePostVO", freepostDAO.findPostDetail(Long.parseLong(post_No)));
		request.setAttribute("url", "freeboard/freePostDetail.jsp");
		return "mainpage.jsp";
	}

}
