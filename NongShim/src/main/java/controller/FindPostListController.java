package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductPostDAO;

public class FindPostListController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductPostDAO dao = ProductPostDAO.getInstance();
		
		
		return "ProductPostMove.do";
	}

}
