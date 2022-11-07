package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import member.NongShimMemberVO;
import model.ProductPostDAO;

public class HooCommentController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//여기부분 세션에서 받아와야함 일단 임시로 아무거나 넣어둠.
		long no=Long.parseLong(request.getParameter("postno"));
		HttpSession session = request.getSession();
		NongShimMemberVO mvo = (NongShimMemberVO) session.getAttribute("mvo");
		String id = mvo.getId();
		String comment= request.getParameter("comment");
		
		
		ProductPostDAO.getInstance().addCommentInHoo(id, no, comment);
		//request.setAttribute("url", "ProductDetailController");
		return "redirect:ProductDetailController.do?postno="+request.getParameter("postno");
		
	}

}
