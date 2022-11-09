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
			StringBuilder sb = new StringBuilder("");
			sb.append("SELECT post_No, title, hits, nickname, register_Date ");
			sb.append("FROM ( SELECT ROW_NUMBER() OVER(ORDER BY post_No DESC) AS rnum, post_No, title, hits, nickname, TO_CHAR(register_Date, 'YYYY-MM-DD') AS register_Date ");
			sb.append("FROM NongShim_Announce_Post) ");
			sb.append("WHERE rnum BETWEEN ? AND ?");
			pst = con.prepareStatement(sb.toString());
			pst.setInt(1, pagination.getStartRowNumber());
			pst.setInt(2, pagination.getEndRowNumber());
			rs= pst.executeQuery();
			while(rs.next()) {
				list.add(new AnnouncePostVO(rs.getLong(1), rs.getString(2), rs.getLong(3), rs.getString(4), rs.getString(5)));
			}
		} finally {
			closeAll(rs, pst, con);
		}
		return list;
	}
	
	public AnnouncePostVO findAnnouncePostDetail(Long post_No) throws SQLException {
		AnnouncePostVO  announcePostVO = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = dataSource.getConnection();
			/*
			 * String sql =
			 * "UPDATE NongShim_Announce_Post SET hits=hits +1 WHERE post_No = ? "; pst =
			 * con.prepareStatement(sql); pst.setLong(1, post_No); pst.executeUpdate();
			 * pst.close();
			 */
			StringBuilder sb = new StringBuilder("");
			sb.append("SELECT post_No, id, title, content, hits, nickname, TO_CHAR(register_Date, 'YYYY-MM-DD') AS register_Date ");
			sb.append("FROM NongShim_Announce_Post ");
			sb.append("WHERE post_No = ?");
			pst = con.prepareStatement(sb.toString());
			pst.setLong(1, post_No);
			rs= pst.executeQuery();
			if(rs.next()) {
				announcePostVO = new AnnouncePostVO(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5), rs.getString(6), rs.getString(7));
			}
		} finally {
			closeAll(rs, pst, con);
		}
		return announcePostVO;
	}
	
	public boolean writeAnnouncePost(AnnouncePostVO announcePostVO) throws SQLException {
		boolean result = false;
		int rs;
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sb = new StringBuilder("");
			sb.append("INSERT INTO NongShim_Announce_Post ");
			sb.append("VALUES (announce_seq.nextval,?,?,?,DEFAULT,DEFAULT,SYSDATE)");
			pst = con.prepareStatement(sb.toString());
			pst.setString(1, announcePostVO.getId());
			pst.setString(2, announcePostVO.getTitle());
			pst.setString(3, announcePostVO.getContent());
			rs= pst.executeUpdate();
			if(rs==1) {
				result = true;
			}
		} finally {
			closeAll(pst, con);
		}
		return result;
	}
	
	public boolean updateAnnouncePost(AnnouncePostVO announcePostVO) throws SQLException {
		boolean result = false;
		int rs;
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sb = new StringBuilder("");
			sb.append("UPDATE NongShim_Announce_Post ");
			sb.append("SET title = ?, content = ? WHERE post_No = ?");
			pst = con.prepareStatement(sb.toString());
			pst.setString(1, announcePostVO.getTitle());
			pst.setString(2, announcePostVO.getContent());
			pst.setLong(3, announcePostVO.getPost_No());
			rs= pst.executeUpdate();
			if(rs==1) {
				result = true;
			}
		} finally {
			closeAll(pst, con);
		}
		return result;
	}
	
	public boolean deleteAnnouncePost(Long post_No ) throws SQLException {
		boolean result = false;
		int rs;
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sb = new StringBuilder("");
			sb.append("DELETE FROM NongShim_Announce_Post ");
			sb.append("WHERE post_No = ?");
			pst = con.prepareStatement(sb.toString());
			pst.setLong(1, post_No);
			rs= pst.executeUpdate();
			if(rs==1) {
				result = true;
			}
		} finally {
			closeAll(pst, con);
		}
		return result;
	}
	
	public void updateHits(long postno) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "UPDATE NongShim_Announce_Post SET hits=hits+1 WHERE post_No=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, postno);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}
}
