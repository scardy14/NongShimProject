package mypage;

import java.sql.SQLException;

import model.MyPageDAO;

public class TestCaseSellercheckUpdate {
	public static void main(String[] args) {
		String id="java";
		try {
			boolean flag=MyPageDAO.getInstance().sellercheckUpdate(id);
			System.out.println(flag);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
