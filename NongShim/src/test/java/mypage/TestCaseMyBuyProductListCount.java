package mypage;

import java.sql.SQLException;

import model.MyPageDAO;

//MyBuyProductListCount : 특정 상태인 구매목록 수
public class TestCaseMyBuyProductListCount {
	public static void main(String[] args) {
		String status="확인중";
		String id="jdbc";
		try {
			int result=MyPageDAO.getInstance().myBuyProductListCount(status,id);
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
