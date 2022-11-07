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
		String mode = request.getParameter("mode");
		if(mode==null) {
			mode = "발송전";
		}

		 ArrayList<BuyProductVO> list=MyPageDAO.getInstance().myBuyProductList(mode,id); 
		 String before="발송전";
		 String after="발송완료"; 
		 
		 int beforeCount=MyPageDAO.getInstance().myBuyProductListCount(before, id); 
		 int afterCount=MyPageDAO.getInstance().myBuyProductListCount(after, id);
		 request.setAttribute("list", list); 
		 request.setAttribute("beforesend",beforeCount); 
		 request.setAttribute("aftersend", afterCount);
		 request.setAttribute("url","mypage/2customer.jsp");
		 return "mainpage.jsp";
	}

}
