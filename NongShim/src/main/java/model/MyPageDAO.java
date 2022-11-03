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
		dataSource = DataSourceManager.getInstance().getDataSource();
	}

	public static MyPageDAO getInstance() {
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

	/**
	 * MySellProductList() : 나의 상태에 따른 판매 목록
	 * 
	 * Logic:
	 * 
	 * NongShim_product_Post 에서 status 가 '판매완료' or '판매중'인데이터만 조회하여 불러옴 요청한 유저의 id와
	 * status를 통해 데이터를 조회함 ArrayList<product post vo>를 리턴해 준다
	 * @jdk
	 */

	public ArrayList<MyPageProductPostVO> mySellProductList(String status, String id) throws SQLException {
		ArrayList<MyPageProductPostVO> list = new ArrayList<>();
		MyPageProductPostVO productPostVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sb = new StringBuilder(
					"select post_no,id,register_date,category,status,product_name,product_point,duration,min_customer,max_customer");
			sb.append(" from NongShim_product_Post where status=? AND  id=? order by register_date desc");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, status);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				productPostVO = new MyPageProductPostVO(rs.getLong(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getLong(7), rs.getString(8),
						rs.getLong(9), rs.getLong(10));
				// System.out.println(productPostVO);
				list.add(productPostVO);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}

	/**
	 * MySellProductListCount(status,id) : 상태에 따른 나의 판매 물품 수
	 * @jdk
	 */
	public int mySellProductListCount(String status, String id) throws SQLException {
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sb = new StringBuilder("select count(*) from NongShim_product_Post where status=? AND  id=?");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, status);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return count;
	}

	/**
	 * MySellProductListTotal(id) : 내 전체 상품 조회
	 * @jdk
	 */

	public ArrayList<MyPageProductPostVO> mySellProductListTotal(String id) throws SQLException {
		ArrayList<MyPageProductPostVO> list = new ArrayList<>();
		MyPageProductPostVO myPageProductPostVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sb = new StringBuilder(
					"select post_no,id,register_date,category,status,product_name,product_point,duration,min_customer,max_customer ");
			sb.append("from NongShim_product_Post where id=? order by register_date desc");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				myPageProductPostVO = new MyPageProductPostVO(rs.getLong(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getLong(7), rs.getString(8),
						rs.getLong(9), rs.getLong(10));
				list.add(myPageProductPostVO);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}

	/**
	 * findCustomerConfirmListbyidandpostno(findCustomer) : '발송'인지 아닌지 확인 매칭 고객 정보
	 * 테이블의 발송 여부 컬럼의 데이터가 '발송'이 이면, true를 반환
	 * @jdk
	 */
	public boolean findCustomerConfirmListbyidandpostno(String customerId, long post_no) throws SQLException {
		boolean flag = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "select post_status from confirm_list where id=? and post_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, customerId);
			pstmt.setLong(2, post_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				flag = true;
				//System.out.println("조회됨");
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return flag;
	}

	/**
	 * -- ChangeBuyState() : 구매 작업에서 참여하기 눌렀으면 디폴트가 확인중이므로, 매칭 고객정보에서 발송여부가 바뀌었을 때,
	 * 확인 중에서 발송완료로 변화
	 * 
	 * findCustomerConfirmListbyidandpostno() 로 '발송'인지 아닌지 확인 매칭 고객 정보 테이블의 발송 여부
	 * 컬럼의 데이터가 '발송'이 이면,
	 * 
	 * 구매상품목록 테이블의 상태가 '확인중'에서 '발송완료'로 바뀐다. flag를 true로 던져줘서 구매 목록 리스트를 다시 불러오게함
	 * 
	 * >> 배송상태 확인 하는 버튼 만들어서 넣어줘야 위 메서드로 상태 변화를 시킬 수 있음 ( post 팀에 요청)
	 * @jdk
	 */

	public boolean changeBuyState(String id, long post_no) throws SQLException {
		boolean flag = false;
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			if (findCustomerConfirmListbyidandpostno(id, post_no) == true) {
				con = dataSource.getConnection();
				String sql = "update buy_product_list set status='발송완료' where id=? and post_no=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setLong(2, post_no);
				result = pstmt.executeUpdate();
				if (result > 0) {
					flag = true;
					//System.out.println("업데이트 완료");
				}
			}
		} finally {
			closeAll(pstmt, con);
		}
		return flag;
	}
	/**
	 * 		StatusUpdatebyDuration() : 판매기간이 종료 되면 자동으로 판매 종료로 UPDATE
	  													post_product 테이블의 duration과 오늘 날짜를 비교하였을 때,
					  									(= 오늘 날짜와 판매기간을 비교하였을 때,)
					  									조회 되는 데이터가 있으면 이 데이터들의 status는 '판매종료'로 업데이트
	 * @throws SQLException 
	 * 
	 * @jdk
	 */

	public int statusUpdatebyDuration() throws SQLException {
		int result=0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql="update NongShim_product_Post set status='판매완료' where duration <= sysdate";
			pstmt=con.prepareStatement(sql);
			result=pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
		return result;
	}

	public ArrayList<BuyProductVO> myBuyProductList(String status, String id) throws SQLException {
		ArrayList<BuyProductVO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con=dataSource.getConnection();
			String sql="select * from buy_product_list where id=? and status=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, status);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BuyProductVO buyProductVO=new BuyProductVO(rs.getString(1),rs.getLong(2),rs.getLong(3),rs.getString(4),rs.getLong(5));
				list.add(buyProductVO);
				System.out.println(buyProductVO);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}

	
	
}
