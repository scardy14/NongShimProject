package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.NongShimMemberDAO;
import member.NongShimMemberVO;

public class FindMemberByNameEmailController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewPath=null;
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		NongShimMemberVO vo =NongShimMemberDAO.getInstance()
		.findIdByNameEmail(name,email);
		if(vo==null) {
			viewPath="login/findbyid-fail.jsp";
		}else {
			request.setAttribute("vo", vo);
			viewPath="login/findbyid-ok.jsp";
		}
		return viewPath;
	}
}
