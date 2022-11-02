package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class ProductPostDAO {
	private static ProductPostDAO instance = new ProductPostDAO();
	private DataSource dataSource;

	private ProductPostDAO() {
		dataSource = DataSourceManager.getInstance().getDataSource();
	}

	public static ProductPostDAO getInstance() {
		return instance;
	}

	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException {
		if (pstmt != null)
			pstmt.close();
		if (con != null)
			con.close();
	}

	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (con != null)
			con.close();
	}

	public Connection getConnection() throws SQLException {

		return dataSource.getConnection();
	}

	@SuppressWarnings("null")
	public ArrayList<ProductPostVO> postFindList() throws SQLException {

		ArrayList<ProductPostVO> list = null;
		ProductPostVO pv = null;

		// 2가지 만들어야함
		// 검색버튼을 눌렀을때 보여주는 리스트와
		// 메인 페이지에서 검색없이 최신순으로 리스트 보여주는.

		// 1.검색창에 입력을 하고 검색버튼 눌므
		// 2. 검색차엥 입력된 입력어가 포함된 자료들을 리스트로 불러온다.
		// 3. return ArrayList
		// 4. 실행될 sql문은 그 포함뭐시기뭐시기... 그거 써야할듯

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select 번호(rownum으로 가져와야할듯), 카테고리, 제목, 작성자, 등록일자, 조회수";
			pstmt = con.prepareStatement(sql);
			// pstmt.setString(1, id);
			// pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				pv = new ProductPostVO();
				list.add(pv);

			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}

	public void postDetailFind() {

	}

	public void writePost() {

	}
	


	public void deletePost() {

	}

	public void updatePost() {

	}

	public void addComment() {

	}

	public void updateComment() {

	}

	public void deleteComment() {

	}

	public void likePost() {

	}

	public void buyProduct() {

	}

	public int getTotalPostCount() throws SQLException {
		//데이터베이스의 NongShim_productPost 테이블의 총 개시물 수를 불러옴
		//입력값: 없음
		//출력값: 총 개시물 수 
		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection con = null;
		int totalpostcount = 0;
		try {
			con = getConnection();
			String sql = "SELECT COUNT(*) FROM NongShim_productPost";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			if(rs.next()) {
				totalpostcount = rs.getInt(1);
			}
		} finally {
			closeAll(rs, pst, con);
		}
		return totalpostcount;
	}

	public ArrayList<ProductPostVO> findPostList(Pagination pagination) throws SQLException {
		//pagination의 시작값과 끝값을 바탕으로 NongShim_productPost에서 정해진 개수만큼의 게시글을 불러옴
		//입력값: pagination
		//출력값: 페이지 정보인 productpostvo 가 담긴 list를 반환
		ArrayList<ProductPostVO> list = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = getConnection();
			StringBuilder sb = new StringBuilder("");
			sb.append("SELECT postNo,title,hits,TO_CHAR(time_posted,'YYYY.MM.DD') as date,category,nickName,status ");
			sb.append("FROM NongShim_productPost");
			pst = con.prepareStatement(sb.toString());
			rs = pst.executeQuery();
			while(rs.next()) {
				list.add(new ProductPostVO(rs.getLong(1), rs.getString(2), rs.getLong(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7)));
			}
		} finally {
			closeAll(rs, pst, con);
		}
		return list;
	}

}
