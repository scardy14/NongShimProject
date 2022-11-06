package ProductPost;

import model.ProductPostDAO;
import model.ProductPostVO;

public class TestCaseUpdatePost {
	public static void main(String[] args) {
		ProductPostVO productpostVO=new ProductPostVO();
		productpostVO.setPostNo(33);
		productpostVO.setTitle("맨첫글수정테스트");
		productpostVO.setContent("수정테스트한다잇");
		try {
			ProductPostDAO.getInstance().updatePost(productpostVO);
			System.out.println(productpostVO+" 수정완룡!!!");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}