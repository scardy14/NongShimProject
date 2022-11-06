package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AnnouncePostDAO;
import model.AnnouncePostVO;

public class UpdateAnnouncePostControllerMove implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AnnouncePostDAO dao = AnnouncePostDAO.getInstance();
		Long post_No = Long.parseLong(request.getParameter("post_No"));
		AnnouncePostVO announcePostVO = dao.findAnnouncePostDetail(post_No);
		request.setAttribute("announcePostVO", announcePostVO);
		request.setAttribute("url", "announceboard/updateannounce.jsp");
		return "mainpage.jsp";
	}

}
