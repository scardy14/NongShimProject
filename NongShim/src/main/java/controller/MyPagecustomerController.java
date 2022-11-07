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
/**
 * 	마이페이지에서 구매 버튼을 눌렀을 때 실행되는 메서드
 * 확인중	확인 완료
 *  value		value
 *  
 *  내가 구매하기로 한 리스트 
 *  타이틀 <- 클릭 시 해당 글로 이동함
 *  ---
 * @author 정다경
 *
 */

public class MyPagecustomerController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//세션-- > 연결해야함 -->연결 완료
		HttpSession session=request.getSession(false);
		NongShimMemberVO mvo=(NongShimMemberVO) session.getAttribute("mvo");
		String id=mvo.getId();
		//System.out.println("*"+id);
		
		//테스트
		 ArrayList<BuyProductVO> list=MyPageDAO.getInstance().myBuyProductListTotal(id); 
		 String buying="구매중";
		 String buy="구매완료"; 
		 
		 int buyingCount=MyPageDAO.getInstance().myBuyProductListCount(buying, id); 
		 int buyCount=MyPageDAO.getInstance().myBuyProductListCount(buy, id);
		 request.setAttribute("list", list); 
		 request.setAttribute("buyingCount",buyingCount); 
		 request.setAttribute("buyCount", buyCount);
		 request.setAttribute("url","mypage/2customer.jsp");
		 return "mainpage.jsp";
	}

}
