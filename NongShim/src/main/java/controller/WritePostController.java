package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.NongShimMemberVO;
import model.ProductPostDAO;
import model.ProductPostVO;

public class WritePostController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		Object object = session.getAttribute("mvo");
		NongShimMemberVO memberVO = (NongShimMemberVO) object;
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String id = memberVO.getId();
		String nickname = memberVO.getNickName();
		String category = request.getParameter("category");
		String comments = "맛있네요";
		String status = "판매중";
		String productname = "청포도";
		long productpoint = Long.parseLong(request.getParameter("productPoint"));
		long mincustomer = Long.parseLong(request.getParameter("minCustomer"));
		long maxcustomer = Long.parseLong(request.getParameter("maxCustomer"));
		System.out.println(title + content + id + nickname+ comments+ category + status + productname + productpoint + mincustomer + maxcustomer);
		ProductPostVO productpostVO= new ProductPostVO(title,content,id,nickname,comments,category,status,
				productname,productpoint,mincustomer,maxcustomer);  
		ProductPostDAO.getInstance().writePost(productpostVO);
		return "redirect:FindPostListByValueController.do"; 
	}
}