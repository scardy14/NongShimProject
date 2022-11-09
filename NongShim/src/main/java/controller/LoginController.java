package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import member.NongShimMemberDAO;
import member.NongShimMemberVO;
import model.MyPageDAO;

public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id=request.getParameter("id");
		String password=request.getParameter("password");
		NongShimMemberVO mvo=NongShimMemberDAO.getInstance().login(id, password);
		String viewPath=null;
		if(mvo==null) {
			viewPath="login/login-fail.jsp"; 
		}else {
			viewPath="index.jsp";
			HttpSession session=request.getSession();
			session.setAttribute("mvo", mvo);
			
			//민석이가 조회수 기능을 위해 한줄 추가했습니다.
			session.setAttribute("hitboard", new ArrayList<Long>());
			session.setAttribute("hitboardAnnounce", new ArrayList<Long>());
			session.setAttribute("hitboardFree", new ArrayList<Long>());
			
			//로또
			
			ArrayList<Integer> list=new ArrayList<>();
			TreeSet<Integer> set=MyPageDAO.getInstance().randomPointNumber();
			Iterator<Integer> iter = set.iterator();
			while(iter.hasNext()) { // iterator에 다음 값이 있다면
				list.add(iter.next()); // iter에서 값 꺼내서 list에 저장
			}
			
			session.setAttribute("lottoNum", list);
			
		}
		
		return viewPath;
	}

}
