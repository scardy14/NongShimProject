package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class findPasswordByIdAccountNoMove implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("url", "login/findPassword-form.jsp");
		return "mainpage.jsp";
	}
}
