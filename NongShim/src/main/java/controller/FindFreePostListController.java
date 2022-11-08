package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FreePostDAO;
import model.Pagination;

public class FindFreePostListController implements Controller {

	@Override
		public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
			FreePostDAO freepostDAO = FreePostDAO.getInstance();
			String pageNo=request.getParameter("pageNo");
			int totalPostCount = freepostDAO.findTotalFreePost();
			Pagination pagination = null;
			if(pageNo==null) {
				pagination=new Pagination(totalPostCount);
			}else {
				pagination=new Pagination(totalPostCount,Integer.parseInt(pageNo));
			}		
			request.setAttribute("url", "freeboard/freePostList.jsp");
			request.setAttribute("list", freepostDAO.findFreePostList(pagination));
			request.setAttribute("pagination", pagination);
			return "mainpage.jsp";
	}
}
