package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.NongShimMemberVO;
import model.BuyProductVO;
import model.MyPageDAO;
import model.ProductPostDAO;
import model.ProductPostVO;

public class MyPagecustomerController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//세션-- > 연결해야함
		HttpSession session=request.getSession(false);
		NongShimMemberVO mvo=(NongShimMemberVO) session.getAttribute("mvo");
		String id=mvo.getId();
		System.out.println("*"+id);
		
		//테스트
		 ArrayList<BuyProductVO> list=MyPageDAO.getInstance().myBuyProductListTotal(id); 
		 String buying="구매중";
		 String buy="구매완료"; 
		 
		 int buyingCount=MyPageDAO.getInstance().myBuyProductListCount(buying, id); 
		 int buyCount=MyPageDAO.getInstance().myBuyProductListCount(buy, id);
		 request.setAttribute("list", list); 
		 request.setAttribute("buyingCount",buyingCount); request.setAttribute("buyCount", buyCount);
		 request.setAttribute("url","mypage/2customer.jsp");
		 return "mainpage.jsp";
	}

}
