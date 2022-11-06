package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AnnouncePostDAO;

public class DeleteAnnouncePostController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long post_No = Long.parseLong(request.getParameter("post_No"));
		AnnouncePostDAO dao = AnnouncePostDAO.getInstance();
		boolean result = dao.deleteAnnouncePost(post_No);
		if(result) {
			return "announceboard/delete-ok.jsp";
		} else {
			return "announceboard/delete-fail.jsp";
		}
	}

}
