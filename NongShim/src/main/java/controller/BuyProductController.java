package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import member.NongShimMemberVO;
import model.MyPageDAO;
import model.ProductPostDAO;

public class BuyProductController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		Long post_No = Long.parseLong(request.getParameter("post_No"));
		ProductPostDAO dao = ProductPostDAO.getInstance();
		request.setAttribute("post_No", post_No);
		
		
		//세션에서 id, point 가져와서 비교 후 insertNsPoint 실행
		String point=request.getParameter("point");
		//System.out.println(point);
		
		long point2=-Long.parseLong(point);
		//System.out.println(point2);
		
		HttpSession session=request.getSession(false);
		NongShimMemberVO memberVO=(NongShimMemberVO) session.getAttribute("mvo");
		String myId=memberVO.getId();
		long myPoint=MyPageDAO.getInstance().getNsPoint(id);
		
		String path=null;
		
		if(myPoint+point2>=0) {
			MyPageDAO.getInstance().insertNsPoint(myId, point2);
			dao.buyProduct(id, post_No);
			path="productboard/buy-ok.jsp";
		} else {
			path="productboard/buy-fail.jsp";
		}
		//포인트-end
		
		//원래코드
		//if(result) {			
		//	return "productboard/buy-ok.jsp";
		//} else {
		//	return "productboard/buy-fail.jsp";
		return path;
		}
	}
//}

