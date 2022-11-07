package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductPostDAO;
import model.ProductPostVO;

public class UpdatePostFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductPostVO productpostvo = ProductPostDAO.getInstance().postDetailFind(no);
		long no=Long.parseLong(request.getParameter("no"));
		request.setAttribute("url", "productboard/update-form.jsp");
		return "mainpage.jsp";
	}

}
