package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FreeCommentDAO;
import model.FreeCommentVO;

public class FindFreePostDetailController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		long postno= Long.parseLong(request.getParameter("postno")); 
		
		ArrayList<FreeCommentVO> commentlist= null;
		commentlist = FreeCommentDAO.getInstance().showAllCommentByPostNo(postno);
		
		request.setAttribute("commentlist", commentlist);
		request.setAttribute("postno",postno);
		request.setAttribute("url", "freeboard/freePostDetail.jsp");
		return "mainpage.jsp";
	}

}
