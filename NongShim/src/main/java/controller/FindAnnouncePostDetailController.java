package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AnnouncePostDAO;

public class FindAnnouncePostDetailController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AnnouncePostDAO dao = AnnouncePostDAO.getInstance();
		String post_No=request.getParameter("post_No");
		request.setAttribute("AnnouncePostVO", dao.findAnnouncePostDetail(Long.parseLong(post_No)));
		request.setAttribute("url", "announceboard/announcePostDetail.jsp");
		return "mainpage.jsp";
	}

}
