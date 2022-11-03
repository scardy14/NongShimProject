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


	public void postDetailFind() {

	}

	public void writePost(ProductPostVO productpostVO) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con=dataSource.getConnection();
			
		}finally {
			closeAll(pstmt, con);
		}
		
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
			String sql = "SELECT COUNT(*) FROM NongShim_product_Post";
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
			sb.append("SELECT post_No, title, hits, TO_CHAR(register_Date, 'YYYY-MM-DD') ");
			sb.append("AS register_Date, category, nickname, status FROM NongShim_product_Post ");
			sb.append("WHERE post_No BETWEEN ? AND ?");
			pst = con.prepareStatement(sb.toString());
			pst.setLong(1, pagination.getStartRowNumber() );
			pst.setLong(2, pagination.getEndRowNumber());
			rs = pst.executeQuery();
			while(rs.next()) {
				//list.add(new ProductPostVO(rs.getLong(1), rs.getString(2), rs.getLong(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7)));
			}
		} finally {
			closeAll(rs, pst, con);
		}
		return list;
	}

}
