package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.NongShimMemberVO;
import model.ConfirmListVO;
import model.MyPageDAO;
import model.MyPageProductPostVO;

public class MyPageMyCustomerListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		NongShimMemberVO memberVO= (NongShimMemberVO) session.getAttribute("mvo");
		//구매를 원하는 사람 목록 -> 내 아이디와 postNo로 찾아옴
		String id=memberVO.getId();
		ArrayList<ConfirmListVO> list=MyPageDAO.getInstance().confirmListbyIdandPostNo(id, request.getParameter("postNo"));
		ArrayList<MyPageProductPostVO> sellerInfo=MyPageDAO.getInstance().mySellProductListTotal(id);
		request.setAttribute("url","mypage/4mycustomerlist.jsp");
		request.setAttribute("list", list);
		request.setAttribute("sellerInfo", sellerInfo);
		return "mainpage.jsp";
	}

}
