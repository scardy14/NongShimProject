package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CommentVO;
import model.ProductPostDAO;
import model.ProductPostVO;

public class ProductDetailController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String postno= request.getParameter("postno");
		ProductPostVO vo= ProductPostDAO.getInstance().postDetailFind(postno);
		ArrayList<CommentVO> list= ProductPostDAO.getInstance().showAllCommentByPostNo(Long.parseLong(postno));
		request.setAttribute("list1", list);
		request.setAttribute("vo",vo);
		request.setAttribute("postno",postno);
		request.setAttribute("url", "productboard/productDetail.jsp");
		return "mainpage.jsp";
	}

}
