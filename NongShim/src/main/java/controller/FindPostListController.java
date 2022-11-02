package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.BoardDAO;
import org.kosta.myproject.model.Pagination;

import model.ProductPostDAO;

public class FindPostListController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductPostDAO dao = ProductPostDAO.getInstance();
		
		String pageNo=request.getParameter("pageNo");
		Pagination pagination=null;
		long totalPostCount=BoardDAO.getInstance().getTotalPostCount();
		if(pageNo==null) {
			pagination=new Pagination(totalPostCount);
		}else {
			pagination=new Pagination(totalPostCount,Long.parseLong(pageNo));
		}		
		request.setAttribute("list", BoardDAO.getInstance().findPostList(pagination));
		request.setAttribute("pagination", pagination);
		request.setAttribute("url", "board/list.jsp");
		return "layout.jsp";
		
		return "ProductPostMove.do";
	}

}
