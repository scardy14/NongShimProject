package mypage;

import java.sql.SQLException;

import model.MyPageDAO;

public class TestCasefindCustomerConfirmListbyidandpostno {
	public static void main(String[] args) {
		String customerId ="spring";
		long post_no=14;
		boolean flag=false;
		try {
			flag=MyPageDAO.getInstance().findCustomerConfirmListbyidandpostno(customerId,post_no);
			System.out.println(flag);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
