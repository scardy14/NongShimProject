package mypage;

<<<<<<< HEAD
import model.ProductPostVO;

public class TestCaseMySellProductList {
	public static void main(String[] args) {
		
=======
import java.util.ArrayList;

import model.MyPageDAO;
import model.ProductPostVO;

public class TestCaseMySellProductList {
	public static void main(String[] args) {
		String status="판매완료";
		ArrayList<ProductPostVO> list=
		MyPageDAO.getInstance().MySellProductList(status);
>>>>>>> refs/heads/jdk-20221107
	}
}
