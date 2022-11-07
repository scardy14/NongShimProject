package mypage;

import java.sql.SQLException;

import model.MyPageDAO;

public class TestCaseChangeBuyState {
	public static void main(String[] args) {
		// 실패하는 경우
		//String id="java";
		//long post_no=10;
		// 성공하는 경우
		//String id="java";
		//long post_no=12;
		String id="spring";
		String post_no="14";
		try {
			boolean flag=MyPageDAO.getInstance().changeBuyState(id,post_no);
			System.out.println(flag);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
