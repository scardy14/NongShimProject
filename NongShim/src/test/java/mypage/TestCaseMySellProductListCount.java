package mypage;

import java.sql.SQLException;

import model.MyPageDAO;

public class TestCaseMySellProductListCount {
	public static void main(String[] args) {
		String status="판매중";
		String id="java";
		try {
			int listCount=MyPageDAO.getInstance().mySellProductListCount(status,id);
			System.out.println(listCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
