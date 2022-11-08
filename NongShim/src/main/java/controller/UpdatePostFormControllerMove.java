package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductPostDAO;
import model.ProductPostVO;

public class UpdatePostFormControllerMove implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		long no=Long.parseLong(request.getParameter("no"));
		ProductPostVO productpostvo = ProductPostDAO.getInstance().postDetailFind(no);
		request.setAttribute("productpostvo", productpostvo);
		request.setAttribute("url", "productboard/update-form.jsp");
		return "mainpage.jsp";
	}

}
