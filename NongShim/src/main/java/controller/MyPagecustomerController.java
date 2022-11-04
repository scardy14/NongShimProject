package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BuyProductVO;
import model.MyPageDAO;

public class MyPagecustomerController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//HttpSession session=request.getSession(false);
		//String id=session.getId();
		String id="java";
		//테스트
		System.out.println(id);
		ArrayList<BuyProductVO> list=MyPageDAO.getInstance().myBuyProductListTotal(id);
		request.setAttribute("list", list);
		request.setAttribute("url", "mypage/1customer.jsp");
		return "mypage/0mypagemain.jsp";
	}

}
