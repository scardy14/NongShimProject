package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import member.NongShimMemberDAO;
import member.NongShimMemberVO;

public class RegisterController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String nickname=request.getParameter("nickname");
		String email=request.getParameter("email");
		String tel=request.getParameter("tel");
		String accountNo=request.getParameter("accountNo");
		NongShimMemberDAO.getInstance().registerMember
		(new NongShimMemberVO(id, name, password, address, nickname, tel, email, 0, accountNo));

		return "redirect:login/regist-result.jsp";
	}

}
