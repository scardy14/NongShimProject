package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.NongShimMemberVO;


public class MyPageUpdateMemberController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String nickName=request.getParameter("nickName");
		String email=request.getParameter("email");
		String tel=request.getParameter("tel");
		String accountNo=request.getParameter("accountNo");
		HttpSession session=request.getSession(false);
		
		NongShimMemberVO mvo=new
		NongShimMemberVO(id, name, password, address, nickName, tel, email, 0, accountNo);
		session.setAttribute("mvo", mvo);
		return "redirect:login/update-result.jsp";
	}

}
