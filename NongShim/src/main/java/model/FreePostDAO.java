package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class FreePostDAO {
	private static FreePostDAO instance = new FreePostDAO();
	private DataSource dataSource;
	private FreePostDAO() {
		dataSource = DataSourceManager.getInstance().getDataSource();
	}
	public static FreePostDAO getInstnace() {
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
	public int findTatalPost() {
		return 0;
	
	}
	public void findFreePostList() {
		
	}
	
	public int findPostDetail() {
		return 0;
	}
	
	public void updatePost() {
		
	}
	
	public void deletePost() {	
		
	}
	
	public void addComment() {
		
	}
	public void updateComment() {
		
	}
	public void deleteComment() {
		
	}
	public void showAllCommentByPostNo() {
		
	}
	public int getTotalPostCount() {
		return 0;
	}
	public int getTotalPostCountValue() {
		return 0;
		
	}
	public int getTotalPostCountSearch() {
		return 0;
		
	}
	public void findPostListByValue() {
		
	}
	public void findPostListBySearch() {
		
	}
	
	public void updateHits() {
		
	}
	
}
