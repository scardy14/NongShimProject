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
	 * 			MySellProductList() : 나의 상태에 따른 판매 목록
	 * 		
	 * 			Logic: 
	 * 
	 *			 NongShim_product_Post 에서 status 가 '판매완료' or '판매중'인데이터만 조회하여 불러옴
	 *			요청한 유저의 id와 status를 통해 데이터를 조회함
	 *			 															ArrayList<product post vo>를 리턴해 준다
	 */
	
	public ArrayList<MyPageProductPostVO> MySellProductList(String status, String id) throws SQLException {
		ArrayList<MyPageProductPostVO> list=new ArrayList<>();
		MyPageProductPostVO productPostVO=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			StringBuilder sb=new StringBuilder("select post_no,id,register_date,category,status,product_name,product_point,duration,min_customer,max_customer");
			sb.append(" from NongShim_product_Post where status=? AND  id=? order by register_date desc");
			pstmt=con.prepareStatement(sb.toString());
			pstmt.setString(1, status);
			pstmt.setString(2, id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				productPostVO=new MyPageProductPostVO(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getLong(7),rs.getString(8),rs.getLong(9),rs.getLong(10));
				//System.out.println(productPostVO);
				list.add(productPostVO);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	
	/*
	 * 			MySellProductListCount(status,id) : 상태에 따른 나의 판매 물품 수
	 */
	public int MySellProductListCount(String status, String id) throws SQLException {
		int count=0;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			StringBuilder sb=new StringBuilder("select count(*) from NongShim_product_Post where status=? AND  id=?");
			pstmt=con.prepareStatement(sb.toString());
			pstmt.setString(1, status);
			pstmt.setString(2, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				count=rs.getInt(1);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return count;
	}
	
	
	/*
	 * 		MySellProductListTotal(id) : 내 전체 상품 조회
	 */
	
	public ArrayList<MyPageProductPostVO> MySellProductListTotal(String id) throws SQLException {
		ArrayList<MyPageProductPostVO> list=new ArrayList<>();
		MyPageProductPostVO myPageProductPostVO=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			StringBuilder sb=new StringBuilder("select post_no,id,register_date,category,status,product_name,product_point,duration,min_customer,max_customer ");
			sb.append("from NongShim_product_Post where id=? order by register_date desc");
			pstmt=con.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				myPageProductPostVO=new MyPageProductPostVO(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getLong(7),rs.getString(8),rs.getLong(9),rs.getLong(10));
				list.add(myPageProductPostVO);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	
	/*
	 * 	 findCustomerConfirmListbyidandpostno(findCustomer) : '발송'인지 아닌지 확인
	 * 																							매칭 고객 정보 테이블의 발송 여부 컬럼의 데이터가 '발송'이 이면,	 
	 */
	public boolean findCustomerConfirmListbyidandpostno(String findCustomer) {		
		return false;
	}
	
	
	

	
	
	
}
