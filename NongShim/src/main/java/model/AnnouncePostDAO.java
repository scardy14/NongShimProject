package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class AnnouncePostDAO {
	private static AnnouncePostDAO instance = new AnnouncePostDAO();
	private DataSource dataSource;

	private AnnouncePostDAO() {
		dataSource = DataSourceManager.getInstance().getDataSource();
	}

	public static AnnouncePostDAO getInstance() {
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
	public int findTotalAnnouncePost() throws SQLException {
		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection con = null;
		int result = 0;
		try {
			con = dataSource.getConnection();
			String sql = "SELECT COUNT(*) FROM NongShim_Announce_Post";
			pst = con.prepareStatement(sql);
			rs= pst.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} finally {
			closeAll(rs, pst, con);
		}
		return result;
	}
	
	public ArrayList<AnnouncePostVO> findAnnouncePostList(Pagination pagination) throws SQLException {
		ArrayList<AnnouncePostVO> list = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql = "SELECT post_No, title, hits, nickname, register_Date FROM NongShim_Announce_Post";
			pst = con.prepareStatement(sql);
			rs= pst.executeQuery();
			while(rs.next()) {
				list.add(new AnnouncePostVO(rs.getLong(1), rs.getString(2), rs.getLong(3), rs.getString(4), rs.getString(5)));
			}
		} finally {
			closeAll(rs, pst, con);
		}
		return list;
	}
}
