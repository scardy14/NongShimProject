package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FreeCommentDAO;
import model.FreeCommentVO;
import model.FreePostDAO;

public class FindFreePostDetailController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
	    
		long postno= Long.parseLong(request.getParameter("post_No")); 
		
		ArrayList<FreeCommentVO> commentlist= null;
		commentlist = FreeCommentDAO.getInstance().showAllCommentByPostNo(postno);
		
		FreePostDAO freepostDAO = FreePostDAO.getInstance();
		request.setAttribute("FreePostVO", freepostDAO.findPostDetail(postno));
		request.setAttribute("commentlist", commentlist);
		request.setAttribute("postno",postno);
		request.setAttribute("url", "freeboard/freePostDetail.jsp");
		return "mainpage.jsp";
	}

}
