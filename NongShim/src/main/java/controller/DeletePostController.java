package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductPostDAO;

public class DeletePostController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("체크완료");
		/*
		 * String no=request.getParameter("no");
		 * ProductPostDAO.getInstance().deletePost(Long.parseLong(no));
		 */
		long no=Long.parseLong(request.getParameter("no"));
		System.out.println(no + "글삭제완료");
		ProductPostDAO.getInstance().deletePost(no);
		return "redirect:FindPostListByValueController.do";
	}
}
