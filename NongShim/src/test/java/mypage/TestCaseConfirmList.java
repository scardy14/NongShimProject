package mypage;

import java.sql.SQLException;
import java.util.ArrayList;
import model.ConfirmListVO;
import model.MyPageDAO;

//구매자 목록 불러오는 메서드 테스트
public class TestCaseConfirmList {
	public static void main(String[] args) {
		ArrayList<ConfirmListVO> list=null;
		String postNo="14";
		try {
			list=MyPageDAO.getInstance().confirmListbyIdandPostNo(postNo);
			System.out.println(list.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
