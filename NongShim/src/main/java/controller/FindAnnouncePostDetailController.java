package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AnnouncePostDAO;
import model.FreePostDAO;

public class FindAnnouncePostDetailController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AnnouncePostDAO dao = AnnouncePostDAO.getInstance();
		
		String post_No=request.getParameter("post_No");
		
		
		 // 조회수 수정하고 있슴다!
        HttpSession session=request.getSession(false);
        
        if(session.getAttribute("mvo")!=null) {
			@SuppressWarnings("unchecked")
			ArrayList<Long> list1=(ArrayList<Long>)session.getAttribute("hitboardAnnounce");
			System.out.println(list1);
			if(list1.contains(Long.parseLong(post_No))==false) {
				AnnouncePostDAO.getInstance().updateHits(Long.parseLong(post_No));
				list1.add(Long.parseLong(post_No));
			}
		}
 //조회수 끝.
		
		request.setAttribute("AnnouncePostVO", dao.findAnnouncePostDetail(Long.parseLong(post_No)));
		request.setAttribute("url", "announceboard/announcePostDetail.jsp");
		

		
		
		
		
		
		return "mainpage.jsp";
	}

}
