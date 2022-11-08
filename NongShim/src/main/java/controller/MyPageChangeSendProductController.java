package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MyPageDAO;

public class MyPageChangeSendProductController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MyPageDAO.getInstance().changeBuyState(request.getParameter("customerId"), request.getParameter("postNo"));
		System.out.println(request.getParameter("customerId"));
		System.out.println(request.getParameter("postNo"));
		return "MyPageMyCustomerListController.do";
	}

}
