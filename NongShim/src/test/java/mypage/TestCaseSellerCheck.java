package mypage;

import java.sql.SQLException;

import model.MyPageDAO;
import model.SellerIdeVO;

public class TestCaseSellerCheck {
	public static void main(String[] args) {
		String id="java";
		try {
			SellerIdeVO sellerIdeVO=MyPageDAO.getInstance().sellerCheck(id);
			System.out.println(sellerIdeVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
