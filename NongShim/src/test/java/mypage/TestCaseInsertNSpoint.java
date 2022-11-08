package mypage;

import java.sql.SQLException;

import model.MyPageDAO;

/*
 *  1. 자유게시판에 글을 쓴다
 *  2. free post 에 글이 등록된다.
 *  <이 부분에 사용할 메서드 테스트>
 *  3. 글을 쓴 아이디에 point 가 등록됨
 *  
 */

public class TestCaseInsertNSpoint {
	public static void main(String[] args) {
		long point=123456;
		String id="java";
		int result=0;
		try {
			result=MyPageDAO.getInstance().insertNsPoint(id,point);
			if(result>0) {
				System.out.println("NS 포인트를"+point+"획득 하셨습니다");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
