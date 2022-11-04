package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ProductPostDAO;

public class WritePostController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equalsIgnoreCase("POST")==false)
			throw new ServletException(getClass().getName()+" POST METHOD 방식만 가능합니다");
		
		HttpSession session=request.getSession(false);
		MemberVO memberVO = session.getAttribute("mvo");
		PostVO postVO=new PostVO();
		ProductPostDAO.getInstance().writePost(postVO);
				
		return "redirect:FindPostListController.do"; 
	}
}