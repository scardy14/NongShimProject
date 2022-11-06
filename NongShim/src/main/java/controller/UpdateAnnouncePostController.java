package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AnnouncePostDAO;
import model.AnnouncePostVO;

public class UpdateAnnouncePostController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AnnouncePostDAO dao = AnnouncePostDAO.getInstance();
		Long post_No = Long.parseLong(request.getParameter("post_No"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		AnnouncePostVO announcePostVO = new AnnouncePostVO(post_No, title, content);
		boolean result = dao.updateAnnouncePost(announcePostVO);
		if(result) {
			return "announceboard/update-ok.jsp";
		} else {
			return "announceboard/update-faill.jsp";
		}
	}

}
