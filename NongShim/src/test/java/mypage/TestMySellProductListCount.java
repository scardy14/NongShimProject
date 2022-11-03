package mypage;

import java.sql.SQLException;

import model.MyPageDAO;

public class TestMySellProductListCount {
	public static void main(String[] args) {
		String status="판매중";
		String id="java";
		try {
			int listCount=MyPageDAO.getInstance().MySellProductListCount(status,id);
			System.out.println(listCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
