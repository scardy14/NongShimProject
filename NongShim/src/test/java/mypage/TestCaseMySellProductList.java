package mypage;

import java.sql.SQLException;
import java.util.ArrayList;

import model.MyPageDAO;
import model.MyPageProductPostVO;
import model.ProductPostVO;

public class TestCaseMySellProductList {
	public static void main(String[] args) {
		String status="판매중";
		String id="java";
		ArrayList<MyPageProductPostVO> list = new ArrayList<>();
		try {
			list =MyPageDAO.getInstance().mySellProductList(status,id);
			System.out.println(list.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
