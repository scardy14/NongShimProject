package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdatePostFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("no",request.getParameter("no"));
		request.setAttribute("title",request.getParameter("title"));
		request.setAttribute("content",request.getParameter("content"));
		request.setAttribute("url", "productboard/update-form.jsp");
		return "productDetail.jsp";
	}

}
