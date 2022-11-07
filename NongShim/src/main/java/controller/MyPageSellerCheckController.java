package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.NongShimMemberVO;
import model.MyPageDAO;
import model.SellerIdeVO;

public class MyPageSellerCheckController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		NongShimMemberVO memberVO=(NongShimMemberVO) session.getAttribute("mvo");
		//String id=memberVO.getId();
		//System.out.println("id:"+id);
		//System.out.println("sellerNumber:"+request.getParameter("sellerNumber"));
		SellerIdeVO sellerIdeVO=new SellerIdeVO(memberVO.getId(),request.getParameter("sellerNumber"));
		MyPageDAO.getInstance().insertSellerCheck(sellerIdeVO);
		MyPageDAO.getInstance().sellercheckUpdate(memberVO.getId());
		request.setAttribute("url","mypage/1myinfo.jsp" );
		return "mainpage.jsp";
	}
}
