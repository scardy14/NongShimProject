package mypage;

import java.sql.SQLException;
import java.util.ArrayList;

import model.MyPageDAO;
import model.MyPageProductPostVO;

public class TestCaseMyFav {
	public static void main(String[] args) {
		String id="java";
		ArrayList<MyPageProductPostVO> list=new ArrayList<>();
		try {
			list=MyPageDAO.getInstance().myFavoriteList(id);
			System.out.println(list.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
