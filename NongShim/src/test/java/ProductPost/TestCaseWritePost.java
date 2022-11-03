package ProductPost;

import model.ProductPostDAO;
import model.ProductPostVO;

public class TestCaseWritePost {
	public static void main(String[] args) {
		try {
			String title="탐스런 과일";
			String content="크고 달아요";
			String id="java";
			String nickName="짱아";
			String comments="맛있네요";
			String category="과일";
			String status="status";
			String productName="청포도";
			long productPoint=100;
			long minCustomer=10;
			long maxCustomer=30;
			ProductPostVO productpostVO=new ProductPostVO();
			productpostVO.setTitle(title);
			productpostVO.setContent(content);
			productpostVO.setId(id);
			productpostVO.setNickName(nickName);
			productpostVO.setComments(comments);
			productpostVO.setCategory(category);
			productpostVO.setStatus(status);
			productpostVO.setProductName(productName);
			productpostVO.setProductPoint(productPoint);
			productpostVO.setMinCustomer(minCustomer);
			productpostVO.setMaxCustomer(maxCustomer);
			ProductPostDAO.getInstance().writePost(productpostVO);
			System.out.println(productpostVO + "상품 글쓰기 완료");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
