package mypage;

import java.sql.SQLException;

import member.NongShimMemberVO;
import model.MyPageDAO;
import model.MyPageMemberVO;


public class TestCaseAdministratorCheck {
	public static void main(String[] args) {
		String id="jdk";
		//select id,admin_INfo from NongShim_Member where id='jdk'
		try {
			MyPageMemberVO myPageMemgerVO=MyPageDAO.getInstance().administratorCheck(id);
			System.out.println(myPageMemgerVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
