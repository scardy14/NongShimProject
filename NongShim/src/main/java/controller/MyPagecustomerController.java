package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MyPageDAO;

public class MyPagecustomerController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=
		session.getAttribute();
		MyPageDAO.getInstance().myBuyProductListTotal()
		request.setAttribute("url", "mypage/1-customer.jsp");
		return "mypage/0-mypagemain.jsp";
	}

}
