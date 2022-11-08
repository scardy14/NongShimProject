package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CommentVO;
import model.ProductPostDAO;
import model.ProductPostVO;

public class ProductDetailController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long postno= Long.parseLong(request.getParameter("postno")); 
		String commentMode = request.getParameter("checkbox");
		
		long cocount=ProductPostDAO.getInstance().showTotalLike(postno);
		request.setAttribute("cocount", cocount);
		
		if(commentMode == null) {
			commentMode = "all";
		}
		HttpSession session=request.getSession(false);
		//**********여기서부터 시험해보는거임**********************
		if(session.getAttribute("mvo")!=null) {
			@SuppressWarnings("unchecked")
			ArrayList<Long> list1=(ArrayList<Long>)session.getAttribute("hitboard");
			if(list1.contains(postno)==false) {
				ProductPostDAO.getInstance().updateHits(postno);
				list1.add(postno);
			}
		}
		
		
		
		ProductPostVO vo= ProductPostDAO.getInstance().postDetailFind(postno);
		
		
		
		ArrayList<CommentVO> commentlist= null;
		if(commentMode.equals("hoo")) {
			commentlist = ProductPostDAO.getInstance().showAllCommentByPostNo(postno, "후기");
		} else if(commentMode.equals("moon")) {
			commentlist = ProductPostDAO.getInstance().showAllCommentByPostNo(postno, "문의");
		} else {
			commentlist = ProductPostDAO.getInstance().showAllCommentByPostNo(postno, commentMode);
		}
		
		request.setAttribute("commentlist", commentlist);
		request.setAttribute("vo",vo);
		request.setAttribute("postno",postno);
		request.setAttribute("url", "productboard/productDetail.jsp");
		request.setAttribute("commentMode", commentMode);
		return "mainpage.jsp";
		

		
	}

}
