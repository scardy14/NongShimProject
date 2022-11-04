package mypage;

import java.sql.SQLException;
import java.util.ArrayList;

import model.BuyProductVO;
import model.MyPageDAO;

public class TestCaseMyBuyProductListTotal {
	public static void main(String[] args) {
		String id="java";
		ArrayList<BuyProductVO> list = new ArrayList<>();
		try {
			list=MyPageDAO.getInstance().myBuyProductListTotal(id);
			System.out.println(list.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
