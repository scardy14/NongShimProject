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
		String postno= request.getParameter("postno");
		
		//**********여기서부터 시험해보는거임**********************
		
		
		long postNo=Long.parseLong(postno);
		//실수로 어떤메서드에는 String no가 들어가고 어떤 곳에는 long no가 들어감 ㅠㅠ ㅅㅂ
		//한번에 맞출떄 통일하겠3
		HttpSession session=request.getSession(false);
		System.out.println(postno);
		System.out.println(postNo);
		@SuppressWarnings("unchecked")
		ArrayList<Long> list1=(ArrayList<Long>)session.getAttribute("hitboard");
		if(list1.contains(postNo)==false) {
			ProductPostDAO.getInstance().updateHits(postNo);
			list1.add(postNo);// 조회수를 증가한 게시글번호를 리스트에 저장한다 
		}
		
		
		
		
		//***시험 끝***************
		
		ProductPostVO vo= ProductPostDAO.getInstance().postDetailFind(postno);
		ArrayList<CommentVO> list= ProductPostDAO.getInstance().showAllCommentByPostNo(Long.parseLong(postno));
		request.setAttribute("list1", list);
		request.setAttribute("vo",vo);
		request.setAttribute("postno",postno);
		request.setAttribute("url", "productboard/productDetail.jsp");
		return "mainpage.jsp";
	}

}
