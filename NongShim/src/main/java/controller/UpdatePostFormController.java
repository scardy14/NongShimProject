package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductPostDAO;
import model.ProductPostVO;

public class UpdatePostFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String no="54";
		ProductPostVO productpostvo = ProductPostDAO.getInstance().postDetailFind(no);
		request.setAttribute("title",productpostvo.getTitle());
		request.setAttribute("content",productpostvo.getContent());
		request.setAttribute("hits",productpostvo.getHits());
		request.setAttribute("nick",productpostvo.getNickName());
		request.setAttribute("comments",productpostvo.getComments());
		request.setAttribute("regdate",productpostvo.getDate());
		request.setAttribute("category",productpostvo.getCategory());
		request.setAttribute("pname",productpostvo.getProductName());
		request.setAttribute("ppoint",productpostvo.getProductPoint());
		request.setAttribute("duration",productpostvo.getDuration());
		request.setAttribute("mincustomer",productpostvo.getMinCustomer());
		request.setAttribute("maxcustomer",productpostvo.getMaxCustomer());
		
		System.out.println(productpostvo.getTitle());
		request.setAttribute("url", "productboard/update-form.jsp");
		return "mainpage.jsp";
	}

}
