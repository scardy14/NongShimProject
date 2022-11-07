package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.NongShimMemberDAO;
import member.NongShimMemberVO;

public class findPasswordByIdAccountNo implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewPath=null;
		String name=request.getParameter("id");
		String email=request.getParameter("accountNo");
		NongShimMemberVO vo =NongShimMemberDAO.getInstance().findPasswordByIdAccountNo(name, email);
		if(vo==null) {
			viewPath="login/findbypassword-fail.jsp";
		}else {
			request.setAttribute("vo", vo);
			viewPath="login/findbypassword-ok.jsp";
		}
		return viewPath;
	}

}
