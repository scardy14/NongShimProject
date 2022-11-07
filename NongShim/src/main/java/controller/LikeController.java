package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductPostDAO;

public class LikeController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String S_no = request.getParameter("postno12");
		// 1. 좋아요 누르면 값을 집어넣는다.
		long no = Long.parseLong(request.getParameter("postno12"));
		String id = request.getParameter("id12");

		//

		if (ProductPostDAO.getInstance().checkLikes(no, id) == true) {
			ProductPostDAO.getInstance().likeCancel(no, id);
			System.out.println("cancel" + no + "  " + id);
		} else {

			ProductPostDAO.getInstance().likePostPush(no, id);
			System.out.println("likePostPush" + no + "  " + id);
		
		}

		// 2. 누적된 좋아요 값을 출력한다.

		long totalLikes = ProductPostDAO.getInstance().showTotalLike(no);
		request.setAttribute("likeTotal", totalLikes);
		
		
		//request.setAttribute("url", "ProductDetailController.do?postno="+ no);
	//	return "mainpage.jsp";
		return "redirect:ProductDetailController.do?postno="+ no;

	}

}
