package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductPostDAO;
import model.ProductPostVO;

public class UpdatePostController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long no=Long.parseLong(request.getParameter("no"));
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		ProductPostVO productpostVO = new ProductPostVO(no,title,content);
		ProductPostDAO.getInstance().updatePost(productpostVO);
		return "redirect:ProductDetailController.do";
	}

}
