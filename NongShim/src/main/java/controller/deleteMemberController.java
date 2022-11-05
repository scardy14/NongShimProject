package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.NongShimMemberDAO;

public class deleteMemberController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id=request.getParameter("id");
		NongShimMemberDAO.getInstance().deleteMemberById(id);
		return "redirect:login/delete-member-result.jsp";
	}

}
