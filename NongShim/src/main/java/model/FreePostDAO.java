package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class FreePostDAO {
	private static FreePostDAO instance = new FreePostDAO();
	private DataSource dataSource;

	private FreePostDAO() {
		dataSource = DataSourceManager.getInstance().getDataSource();
	}

	public static FreePostDAO getInstance() {
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
		closeAll(pstmt, con);
	}

	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	public int findTotalPost() {
		return 0;
	}

	public int findTatalPost() {

		return 0;

	}

	public int findTotalFreePost() throws SQLException {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection con = null;
		int result = 0;
		try {
			con = dataSource.getConnection();
			String sql = "SELECT COUNT(*) FROM NongShim_Free_Post";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return result;
	}

	public ArrayList<FreePostVO> findFreePostList(Pagination pagination) throws SQLException {
		ArrayList<FreePostVO> list = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sb = new StringBuilder("");
			sb.append("SELECT post_No, title, hits, nickname, register_Date ");
			sb.append(
					"FROM (SELECT row_number() over(order by post_No DESC)AS rnum, post_No, title, hits, nickname, TO_CHAR(register_Date, 'YYYY-MM-DD') AS register_Date ");
			sb.append("FROM NongShim_free_post) ");
			sb.append("WHERE rnum BETWEEN ? AND ?");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, pagination.getStartRowNumber());
			pstmt.setInt(2, pagination.getEndRowNumber());
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				list.add(new FreePostVO(rs.getLong(1), rs.getString(2), rs.getLong(3), rs.getString(4),
						rs.getString(5)));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}

	public FreePostVO findPostDetail(Long post_No) throws SQLException {
		FreePostVO freepostVO = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql = "UPDATE NongShim_Free_Post SET hits=hits +1 WHERE post_No = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, post_No);
			pstmt.executeUpdate();
			pstmt.close();
			StringBuilder sb = new StringBuilder("");
			sb.append(
					"SELECT post_No, id, title, content, hits, nickname, TO_CHAR(register_Date, 'YYYY-MM-DD') AS register_Date ");
			sb.append("FROM NongShim_Free_Post ");
			sb.append("WHERE post_No = ?");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setLong(1, post_No);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				freepostVO = new FreePostVO(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getLong(5), rs.getString(6), rs.getString(7));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return freepostVO;
	}

	public void writePost(FreePostVO freepostVO) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sb = new StringBuilder("");
			sb.append("INSERT INTO NongShim_Free_Post ");
			sb.append("VALUES (free_seq.nextval,?,?,?,?,DEFAULT,SYSDATE)");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, freepostVO.getId());
			pstmt.setString(2, freepostVO.getTitle());
			pstmt.setString(3, freepostVO.getNickname());
			pstmt.setString(4, freepostVO.getContent());
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}

	public void updatePost(FreePostVO FreePostVO) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sb = new StringBuilder("");
			sb.append("UPDATE NongShim_Free_Post ");
			sb.append("SET title = ?, content = ? WHERE post_No = ?");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, FreePostVO.getTitle());
			pstmt.setString(2, FreePostVO.getContent());
			pstmt.setLong(3, FreePostVO.getPost_No());
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}

	public void deletePost(Long post_No) throws SQLException {
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sb = new StringBuilder("");
			sb.append("DELETE FROM NongShim_Free_Post ");
			sb.append("WHERE post_No = ?");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setLong(1, post_No);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}

	

	public void updateComment() {

	}

	public void deleteComment() {

	}

	public void showAllCommentByPostNo() {

	}

	public void updateHits() {

	}

}
