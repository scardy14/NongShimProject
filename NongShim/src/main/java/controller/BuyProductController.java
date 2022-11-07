package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductPostDAO;

public class BuyProductController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		Long post_No = Long.parseLong(request.getParameter("post_No"));
		ProductPostDAO dao = ProductPostDAO.getInstance();
		boolean result = dao.buyProduct(id, post_No);
		request.setAttribute("post_No", post_No);
		if(result) {			
			return "productboard/buy-ok.jsp";
		} else {
			return "productboard/buy-fail.jsp";
		}
	}

}
