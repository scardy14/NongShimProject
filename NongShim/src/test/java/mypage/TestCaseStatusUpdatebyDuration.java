package mypage;

import java.sql.SQLException;

import model.MyPageDAO;

public class TestCaseStatusUpdatebyDuration {
	public static void main(String[] args) {
		try {
			int count=MyPageDAO.getInstance().statusUpdatebyDuration();
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
