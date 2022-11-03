package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	/*
	 * 			MySellProductList() : 나의 판매완료 목록
	 * 											 판매중인 제품의 상태 변화가 '판매완료'이면 해당 데이터만 불러옴
	 * 			
	 * 			Logic: 
	 *			 NongShim_product_Post 의 status 가 '판매완료' 이면 해당 데이터만 조회하여 불러옴
	 *			 															ArrayList<product post vo>를 리턴해 준다
	 */
	
	public ArrayList<ProductPostVO> MySellProductList(String status) {
		ArrayList<ProductPostVO> list=new ArrayList<>();
		
		return list;
	}
	

	
	
	
}
