package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MyPageDAO;
import model.MyPageProductPostVO;

public class MyPageSellerTotalController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id="java";
		ArrayList<MyPageProductPostVO> list=MyPageDAO.getInstance().mySellProductListTotal(id);
		String selling="판매중";
		String sell="판매완료";
		int sellingCount =MyPageDAO.getInstance().mySellProductListCount(selling, id);
		int sellCount=MyPageDAO.getInstance().mySellProductListCount(sell, id);
		System.out.println(list.toString());
		request.setAttribute("sellerList",list);
		request.setAttribute("url", "mypage/3seller.jsp");
		request.setAttribute("selling", sellingCount);
		request.setAttribute("sell", sellCount);
		return "mainpage.jsp";
	}

}
