package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdatePostFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("category",request.getParameter("category"));
		request.setAttribute("mincustomer",request.getParameter("mincustomer"));
		request.setAttribute("maxcustomer",request.getParameter("maxcustomer"));
		request.setAttribute("productpoint",request.getParameter("productpoint"));
		request.setAttribute("duration",request.getParameter("duration"));
		request.setAttribute("title",request.getParameter("title"));
		request.setAttribute("content",request.getParameter("content"));
		request.setAttribute("no",request.getParameter("no"));
		request.setAttribute("url", "productboard/update-form.jsp");
		return "mainpage.jsp";
	}

}
