package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.NongShimMemberVO;
import model.AnnouncePostDAO;
import model.AnnouncePostVO;


public class WriteAnnouncePostController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AnnouncePostDAO dao = AnnouncePostDAO.getInstance();
		HttpSession session = request.getSession(false);
		NongShimMemberVO mvo = (NongShimMemberVO) session.getAttribute("mvo");
		String id = mvo.getId();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		AnnouncePostVO announcePostVO = new AnnouncePostVO(id, title, content);
		boolean result = dao.writeAnnouncePost(announcePostVO);
		
		request.setAttribute("result", result);
		request.setAttribute("url", "FindAnnouncePostListController.do");
		return "redirect:FindAnnouncePostListController.do";
	}

}
