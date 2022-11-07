package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.NongShimMemberDAO;
import member.NongShimMemberVO;


public class MyPageUpdateMemberController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String nickName=request.getParameter("nickname");
		String email=request.getParameter("email");
		String tel=request.getParameter("tel");
		String accountNo=request.getParameter("accountNo");
		NongShimMemberVO mvo=new
		NongShimMemberVO(id, name, password, address, nickName, tel, email, 0, accountNo);
		NongShimMemberDAO.getInstance().updateMember(mvo);
		HttpSession session=request.getSession(false);
		session.setAttribute("mvo", mvo);
		session.invalidate();
		return "redirect:login/update-result.jsp";
	}

}
