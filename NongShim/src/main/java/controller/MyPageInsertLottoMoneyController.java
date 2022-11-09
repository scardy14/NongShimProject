package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.NongShimMemberVO;
import model.MyPageDAO;

public class MyPageInsertLottoMoneyController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		NongShimMemberVO memberVO=(NongShimMemberVO) session.getAttribute("mvo");
		String id=memberVO.getId();
		String result=request.getParameter("result");
		//System.out.println("******************");
		//System.out.println("result: "+result);
		
		long nsPoint=(long) session.getAttribute("nsPoint");
		//복권 구매시 point 50원 차감
		nsPoint=MyPageDAO.getInstance().insertNsPoint(id, -50);
		
		if(result.contains("꽝!")) {
			return "MyPageTodayLottoMoneyController.do";
		}else {
		long point=Long.parseLong(result);
		nsPoint=MyPageDAO.getInstance().insertNsPoint(id, point);
		}
		session.setAttribute("nsPoint", nsPoint);
		return "MyPageTodayLottoMoneyController.do";
	}

}
