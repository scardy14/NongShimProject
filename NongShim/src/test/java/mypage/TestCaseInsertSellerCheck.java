package mypage;

import java.sql.SQLException;

import model.MyPageDAO;
import model.SellerIdeVO;

public class TestCaseInsertSellerCheck {
	public static void main(String[] args) {
		String id="java";
		String sellerNum="0123456789";
		SellerIdeVO sellerIdeVO=new SellerIdeVO(id, sellerNum);
		try {
			boolean flag=MyPageDAO.getInstance().insertSellerCheck(sellerIdeVO);
			System.out.println(flag);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
