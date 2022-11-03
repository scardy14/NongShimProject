package mypage;

import model.MyPageDAO;

public class TestCasefindCustomerConfirmListbyidandpostno {
	public static void main(String[] args) {
		String findCustomer="발송";
		boolean flag=MyPageDAO.getInstance().findCustomerConfirmListbyidandpostno(findCustomer);
	}
}
