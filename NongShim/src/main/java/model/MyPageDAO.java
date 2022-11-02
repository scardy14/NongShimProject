package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class MyPageDAO {
	private static MyPageDAO instance = new MyPageDAO();
	private DataSource dataSource;
	private MyPageDAO() {
		dataSource=DataSourceManager.getInstance().getDataSource();
	}
	public static MyPageDAO getInstance() {
		return instance;
	}
	public void closeAll(PreparedStatement pstmt,Connection con) throws SQLException {
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close();
	}
	public void closeAll(ResultSet rs,PreparedStatement pstmt,Connection con) throws SQLException {
		if(rs!=null)
			rs.close();
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close();
	}
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
	//MyBuyProductList()
	
	
	
}
