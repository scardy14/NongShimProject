package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductPostDAO;
import model.ProductPostVO;

public class ProductDetailController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String postno= request.getParameter("postno");
		ProductPostVO vo= ProductPostDAO.getInstance().postDetailFind(postno);
		request.setAttribute("vo",vo);
		request.setAttribute("url", "productboard/productDetail.jsp");
		return "mainpage.jsp";
	}

}
