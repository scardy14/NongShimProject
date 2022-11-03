package controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pagination;
import model.ProductPostDAO;

public class FindPostListByCheckbox implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductPostDAO dao = ProductPostDAO.getInstance();
		String checkbox = request.getParameter("checkbox");
		System.out.println(checkbox);
		String pageNo=request.getParameter("pageNo");
		Pagination pagination=null;
		int totalPostCount=dao.getTotalPostCount();
		if(pageNo==null) {
			pagination=new Pagination(totalPostCount);
		}else {
			pagination=new Pagination(totalPostCount,Integer.parseInt(pageNo));
		}		
		request.setAttribute("list",dao.findPostListByCheckbox(pagination, checkbox));
		request.setAttribute("pagination", pagination);
		request.setAttribute("url", "board/list.jsp");
		request.setAttribute("url", "productboard/list.jsp");
		return "mainpage.jsp";
	}

}
