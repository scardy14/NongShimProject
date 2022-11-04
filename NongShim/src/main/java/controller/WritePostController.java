package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.NongShimMemberVO;
import model.ProductPostDAO;
import model.ProductPostVO;

public class WritePostController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session=request.getSession(false);
		NongShimMemberVO memberVO = (NongShimMemberVO) session.getAttribute("mvo");
		ProductPostVO productpostVO= new ProductPostVO();
		ProductPostDAO.getInstance().writePost(productpostVO);
		return "redirect:FindPostListController.do"; 
	}
}