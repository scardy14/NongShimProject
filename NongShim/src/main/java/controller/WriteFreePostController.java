package controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import member.NongShimMemberVO;
import model.FreePostDAO;
import model.FreePostVO;
import model.MyPageDAO;


public class WriteFreePostController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		Object object = session.getAttribute("mvo");
		NongShimMemberVO memberVO = (NongShimMemberVO) object;
		String id = memberVO.getId();
		String nickname=memberVO.getNickName();
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		FreePostVO freePostVO=new FreePostVO(id, title, content, nickname);
		FreePostDAO.getInstance().writePost(freePostVO);
		
		//글쓰고 포인트 받기 -->  된다면 받은 포인트를 session에 재할당 해보기
		MyPageDAO.getInstance().insertNsPoint(id, 100);
		
		return "redirect:FindFreePostListController.do";
		} 
	}
