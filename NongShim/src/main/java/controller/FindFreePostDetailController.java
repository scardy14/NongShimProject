package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.FreeCommentDAO;
import model.FreeCommentVO;
import model.FreePostDAO;
import model.ProductPostDAO;

public class FindFreePostDetailController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FreePostDAO freepostDAO = FreePostDAO.getInstance();
        String post_No=request.getParameter("post_No");
        long postno= Long.parseLong(post_No); 
     
        ArrayList<FreeCommentVO> commentlist= null;
        commentlist = FreeCommentDAO.getInstance().showAllCommentByPostNo(postno);
  
      // 조회수 수정하는 부분 
        HttpSession session=request.getSession(false);
        if(session.getAttribute("mvo")!=null) {
			@SuppressWarnings("unchecked")
			ArrayList<Long> list1=(ArrayList<Long>)session.getAttribute("hitboardFree");
			System.out.println(list1);
			if(list1.contains(postno)==false) {
				FreePostDAO.getInstance().updateHits(postno);
				list1.add(postno);
			}
		}
 //조회수 끝.

        request.setAttribute("FreePostVO", freepostDAO.findPostDetail(postno));
        request.setAttribute("commentlist", commentlist);
        request.setAttribute("postno",postno);
        request.setAttribute("url", "freeboard/freePostDetail.jsp");
        return "mainpage.jsp";
	}
}
