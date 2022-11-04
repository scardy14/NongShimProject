package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AnnouncePostDAO;
import model.Pagination;

public class FindAnnouncePostListController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AnnouncePostDAO dao = AnnouncePostDAO.getInstance();
		String pageNo=request.getParameter("pageNo");
		int totalPostCount = dao.findTotalAnnouncePost() ;
		Pagination pagination = null;
		if(pageNo==null) {
			pagination=new Pagination(totalPostCount);
		}else {
			pagination=new Pagination(totalPostCount,Integer.parseInt(pageNo));
		}		
		request.setAttribute("url", "announceboard/announcepostlist.jsp");
		request.setAttribute("list", dao.findAnnouncePostList(pagination));
		request.setAttribute("pagination", pagination);
		return "mainpage.jsp";
	}

}
