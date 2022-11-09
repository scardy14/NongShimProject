package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import member.NongShimMemberVO;
import model.MyPageDAO;
import model.MyPageProductPostVO;
import model.Pagination;

public class MyPageSellerTotalController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//세션 받아오기
		HttpSession session=request.getSession(false);
		NongShimMemberVO mvo=(NongShimMemberVO) session.getAttribute("mvo");
		String id=mvo.getId();
		String mode = request.getParameter("mode");
		if(mode==null) {
			mode = "판매중";
		}
		//리스트 받아오기
		////////////////////////////
		MyPageDAO dao = MyPageDAO.getInstance();
		String pageNo=request.getParameter("pageNo");
			System.out.println(pageNo);
		Pagination pagination=null;
		int totalPostCount;
		totalPostCount = dao.myBuyProductListCount(mode, id);
		if(pageNo==null) {
			pagination=new Pagination(totalPostCount);
		}else {
			pagination=new Pagination(totalPostCount,Integer.parseInt(pageNo));
		}		
		////////////////////////////
		ArrayList<MyPageProductPostVO> list=dao.mySellProductListTotal(id, mode, pagination);
		String selling="판매중";
		String sell="판매완료";
		int sellingCount =MyPageDAO.getInstance().mySellProductListCount(selling, id);
		int sellCount=MyPageDAO.getInstance().mySellProductListCount(sell, id);
		MyPageDAO.getInstance().statusUpdatebyDuration();
		//System.out.println(list.toString());
		request.setAttribute("sellerList",list);
		request.setAttribute("url", "mypage/3seller.jsp");
		request.setAttribute("selling", sellingCount);
		request.setAttribute("sell", sellCount);
		return "mainpage.jsp";
	}

}
