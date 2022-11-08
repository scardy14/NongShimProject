package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductPostDAO;
import model.ProductPostVO;

public class UpdateProductPostController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 long no=Long.parseLong(request.getParameter("no")); 
		 String	 category=request.getParameter("category"); 
		 long mincustomer = Long.parseLong(request.getParameter("minCustomer")); 
		 long maxcustomer = Long.parseLong(request.getParameter("maxCustomer")); 
		 long productpoint = Long.parseLong(request.getParameter("productPoint"));
		 String duration= request.getParameter("duration");
		 String title=request.getParameter("title");
		 String content=request.getParameter("content"); 		 	
		ProductPostVO productpostVO = new ProductPostVO(no,title,content,category,productpoint,duration,mincustomer,maxcustomer);
		ProductPostDAO.getInstance().updatePost(productpostVO);
		return "redirect:FindPostListByValueController.do";
	}

}
