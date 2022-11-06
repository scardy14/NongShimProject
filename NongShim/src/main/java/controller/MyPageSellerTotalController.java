package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import model.MyPageDAO;
import model.MyPageProductPostVO;

public class MyPageSellerTotalController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//세션 받아오기
		HttpSession session=request.getSession(false);
		String id=session.;
		System.out.println(id);
		//리스트 받아오기
		ArrayList<MyPageProductPostVO> list=MyPageDAO.getInstance().mySellProductListTotal(id);
		//String selling="판매중";
		//String sell="판매완료";
		int sellingCount =MyPageDAO.getInstance().mySellProductListCount("판매중", id);
		int sellCount=MyPageDAO.getInstance().mySellProductListCount("판매완료", id);
		//System.out.println(list.toString());
		request.setAttribute("sellerList",list);
		request.setAttribute("url", "mypage/3seller.jsp");
		request.setAttribute("selling", sellingCount);
		request.setAttribute("sell", sellCount);
		return "mainpage.jsp";
	}

}
