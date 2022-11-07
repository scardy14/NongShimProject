package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.NongShimMemberDAO;

public class deleteMemberController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id=request.getParameter("id");
		NongShimMemberDAO.getInstance().deleteMemberById(id);
		HttpSession session=request.getSession(false);
		if(session!=null) {
			session.invalidate();
		}
		return "redirect:login/delete-member-result.jsp";
	}

}
