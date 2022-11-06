package ProductPost;

import model.ProductPostDAO;

public class TestCaseDeletePost {
	public static void main(String[] args) {
		try {
			long no=31;
			ProductPostDAO.getInstance().deletePost(no);
			System.out.println(no+"번 게시글 삭제 완룡!!");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
