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
		System.out.println(list.toString());
		request.setAttribute("sellerList",list);
		request.setAttribute("url", "mypage/3seller.jsp");
		return "mainpage.jsp";
	}

}
