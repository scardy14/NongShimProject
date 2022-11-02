package mypage;

import java.util.ArrayList;

import model.MyPageDAO;
import model.ProductPostVO;

public class TestCaseMySellProductList {
	public static void main(String[] args) {
		String status="판매완료";
		ArrayList<ProductPostVO> list=
		MyPageDAO.getInstance().MySellProductList(status);
	}
}
