package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pagination;
import model.ProductPostDAO;
import model.ProductPostVO;

public class FindPostListBySearchController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductPostDAO dao = ProductPostDAO.getInstance();
		String inputvalue =	request.getParameter("inputbox");
		String pageNo=request.getParameter("pageNo");
		Pagination pagination=null;
		int totalPostCount;
		totalPostCount =dao.getTotalPostCountSearch(inputvalue);
		if(pageNo==null) {
			pagination=new Pagination(totalPostCount);
		}else {
			pagination=new Pagination(totalPostCount,Integer.parseInt(pageNo));
		}	
		ArrayList<ProductPostVO> list = dao.findPostListBySearch(pagination, inputvalue);
		
		
		String[] checkboxlist = {"all","곡물","야채","과일"};
		request.setAttribute("checkboxlist", checkboxlist);
		request.setAttribute("list", list);
		request.setAttribute("pagination", pagination);
		request.setAttribute("url", "productboard/list.jsp");
		request.setAttribute("mode", "search");
		request.setAttribute("inputvalue", inputvalue);
		return "mainpage.jsp";
	}

}
