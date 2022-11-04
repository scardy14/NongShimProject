package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomerToMainpageMove implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//request.setAttribute("url2", request.getParameter("url2"));
		//System.out.println(request.getParameter("url2"));
		request.setAttribute("url", "mypage/0mypagemain.jsp");
		return "mainpage.jsp";
	}

}
