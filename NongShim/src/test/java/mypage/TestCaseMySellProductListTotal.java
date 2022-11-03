package mypage;

import java.sql.SQLException;
import java.util.ArrayList;

import model.MyPageDAO;
import model.MyPageProductPostVO;

public class TestCaseMySellProductListTotal {
	public static void main(String[] args) {
		String id="java";
		try {
			ArrayList<MyPageProductPostVO> list = MyPageDAO.getInstance().MySellProductListTotal(id);
			System.out.println(list.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
