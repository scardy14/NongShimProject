package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class FreeCommentDAO {
	private static FreeCommentDAO instance = new FreeCommentDAO();
	private DataSource dataSource;

	private FreeCommentDAO() {
		dataSource = DataSourceManager.getInstance().getDataSource();
	}

	public static FreeCommentDAO getInstance() {
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

	public void addComment(String id, String nick, long postno, String comment) throws SQLException {
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = getConnection();
			String sql = "insert into NongShim_Free_Post_Comments values (?,?,?,sysdate,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, nick);
			pst.setLong(3, postno);
			pst.setString(4, comment);
			pst.executeUpdate();

		} finally {
			closeAll(pst, con);
		}
	}

	public void deleteComment(long commentNo) throws SQLException {

		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = getConnection();
			String sql = "delete from NongShim_Free_Post_Comments where comment_no=?";
			pst = con.prepareStatement(sql);
			
			pst.executeUpdate();

		} finally {
			closeAll(pst, con);
		}

	}

	public void updateComment(String content, String id, long no, String date) throws SQLException {
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = getConnection();
			String sql = "update NongShim_Free_Post_Comments set content = ? where id=? and post_no=? and comments_date=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, content);
			pst.setString(2, id);
			pst.setLong(3, no);
			pst.setString(4, date);
			pst.executeUpdate();

		} finally {
			closeAll(pst, con);
		}
	}

	public ArrayList<FreeCommentVO> showAllCommentByPostNo(long postno) throws SQLException {

		ArrayList<FreeCommentVO> list = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = getConnection();

			String sql = "select row_number() over(order by comments_date) as rnum,content,id,nickName,to_char(comments_date,'YYYY-MM-DD HH24:MI') AS comments_date from NongShim_Free_Post_Comments where post_no=?";

			pst = con.prepareStatement(sql);
			pst.setLong(1, postno);
			rs = pst.executeQuery();

			while (rs.next()) {
				list.add(new FreeCommentVO(rs.getLong(1), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(2)));
			}

		} finally {
			closeAll(rs, pst, con);
		}
		return list;

	}

}
