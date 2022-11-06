package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BuyProductVO;
import model.MyPageDAO;
import model.ProductPostDAO;
import model.ProductPostVO;

public class MyPagecustomerController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//세션-- > 연결해야함
		//HttpSession session=request.getSession(false);
		String id="java";
		//테스트
		ArrayList<BuyProductVO> list=MyPageDAO.getInstance().myBuyProductListTotal(id);
		request.setAttribute("list", list);
		request.setAttribute("url","mypage/2customer.jsp");
		return "mainpage.jsp";
	}

}
