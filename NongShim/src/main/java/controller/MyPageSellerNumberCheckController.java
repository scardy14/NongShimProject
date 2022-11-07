package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MyPageDAO;

public class MyPageSellerNumberCheckController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String sellerNumber=request.getParameter("sellerNumber");
		boolean flag=MyPageDAO.getInstance().sellerNumberCheck(sellerNumber);
		String result=null;
		if(flag) {
			result="fail";
		} else {
			result="ok";
		}
		request.setAttribute("responsebody", result);
		return "AjaxView";
	}

}
