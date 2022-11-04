package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductPostDAO;

public class DeletePostController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equalsIgnoreCase("POST")==false)
			throw new ServletException(getClass().getName()+" post 방식만 서비스 가능합니다");
		
		String no=request.getParameter("no");
		ProductPostDAO.getInstance().deletePost(Long.parseLong(no));
		return "redirect:FindPostListController.do";
	}

}
