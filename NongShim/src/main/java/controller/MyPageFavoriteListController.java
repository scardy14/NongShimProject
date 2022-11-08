package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.NongShimMemberVO;
import model.MyPageDAO;
import model.MyPageProductPostVO;

public class MyPageFavoriteListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		NongShimMemberVO memberVO=(NongShimMemberVO) session.getAttribute("mvo");
		ArrayList<MyPageProductPostVO> list=MyPageDAO.getInstance().myFavoriteList(memberVO.getId());
		request.setAttribute("list", list);
		request.setAttribute("url","mypage/6favorite.jsp");
		return "mainpage.jsp";
	}

}
