package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

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
	 * MySellProductList(String status, String id) : 나의 상태에 따른 판매 목록
	 * 
	 * Logic:
	 * 
	 * NongShim_product_Post 에서 status 가 '판매완료' or '판매중'인데이터만 조회하여 불러옴 요청한 유저의 id와
	 * status를 통해 데이터를 조회함 ArrayList<product post vo>를 리턴해 준다
	 * 
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
	 * MySellProductListCount(String status, String id) : 상태에 따른 나의 판매 물품 수
	 * 
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
	 * MySellProductListTotal(String id) : 내 전체 상품 조회
	 * 
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
			StringBuilder sb = new StringBuilder("select post_no,title,id,register_date,status,duration,min_customer,max_customer,");
			sb.append("(7-(to_date(duration,'yyyy-mm-dd')-to_date(sysdate,'yyyy-mm-dd')))/7*100 as diff ");
			sb.append("from NongShim_product_Post where id=? order by register_date desc");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				myPageProductPostVO = new MyPageProductPostVO(rs.getLong(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getLong(7), rs.getLong(8),rs.getLong(9));
				list.add(myPageProductPostVO);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}

	/**
	 * FindCustomerConfirmListbyidandpostno(String customerId, long post_no) :
	 * '발송'인지 아닌지 확인 매칭 고객 정보 테이블의 발송 여부 컬럼의 데이터가 '발송'이 이면, true를 반환
	 * 
	 * @jdk
	 */
	public boolean findCustomerConfirmListbyidandpostno(String customerId, String post_no) throws SQLException {
		boolean flag = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "select post_status from confirm_list where id=? and post_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, customerId);
			pstmt.setString(2, post_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				flag = true;
				// System.out.println("조회됨");
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return flag;
	}

	
	
	
	
	
	
	/**
	 * -- ChangeBuyState(String id, long post_no) : 구매 작업에서 참여하기 눌렀으면 디폴트가 확인중이므로,
	 * 매칭 고객정보에서 발송여부가 바뀌었을 때, 확인 중에서 발송완료로 변화
	 * 
	 * findCustomerConfirmListbyidandpostno() 로 '발송'인지 아닌지 확인 매칭 고객 정보 테이블의 발송 여부
	 * 컬럼의 데이터가 '발송'이 이면,
	 * 
	 * 구매상품목록 테이블의 상태가 '확인중'에서 '발송완료'로 바뀐다. flag를 true로 던져줘서 구매 목록 리스트를 다시 불러오게함
	 * 
	 * >> 배송상태 확인 하는 버튼 만들어서 넣어줘야 위 메서드로 상태 변화를 시킬 수 있음 ( post 팀에 요청)
	 * 
	 * @jdk
	 */

	public boolean changeBuyState(String id,String post_no) throws SQLException {
		boolean flag = false;
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			if (findCustomerConfirmListbyidandpostno(id, post_no) == true) {
				con = dataSource.getConnection();
				String sql = "update confirm_list set post_status='발송완료' where post_no=? and id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, post_no);
				pstmt.setString(2, id);
				pstmt.executeUpdate();
				pstmt.close();
				
				String sql2="update buy_product_list set status='발송완료' where post_no=? and id=?";
				pstmt=con.prepareStatement(sql2);
				pstmt.setString(1, post_no);
				pstmt.setString(2, id);
				pstmt.executeUpdate();
				if (result > 0) {
					flag = true;
					System.out.println("업데이트 완료");
				}
			}
		} finally {
			closeAll(pstmt, con);
		}
		return flag;
	}

	/**
	 * StatusUpdatebyDuration() : 판매기간이 종료 되면 자동으로 판매 종료로 UPDATE post_product 테이블의
	 * duration과 오늘 날짜를 비교하였을 때, (= 오늘 날짜와 판매기간을 비교하였을 때,) 조회 되는 데이터가 있으면 이 데이터들의
	 * status는 '판매종료'로 업데이트
	 * 
	 * @throws SQLException
	 * 
	 * @jdk
	 */

	public int statusUpdatebyDuration() throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "update NongShim_product_Post set status='판매완료' where duration <= sysdate";
			pstmt = con.prepareStatement(sql);
			result = pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
		return result;
	}

	/**
	 * -- MyBuyProductList(String status, String id) : 특정 상태인 구매목록(최신순)
	 * 
	 * @param status
	 * @param id
	 * @return
	 * @throws SQLException
	 */

	public ArrayList<BuyProductVO> myBuyProductList(String status, String id) throws SQLException {
		ArrayList<BuyProductVO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			//String sql = "select * from buy_product_list where id=? and status=? order by ns_date desc";
			StringBuilder sb=new StringBuilder("select b.id,b.post_no,b.ns_date,b.status,b.amount,p.title ");
			sb.append("from (select * from buy_product_list where id=? and status=?) b ");
			sb.append("inner join NongShim_product_Post p on b.post_no=p.post_no ");
			sb.append("order by ns_date desc");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, status);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BuyProductVO buyProductVO = new BuyProductVO(rs.getString(1), rs.getLong(2), rs.getString(3),
						rs.getString(4), rs.getLong(5),rs.getString(6));
				list.add(buyProductVO);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	
	/**
	 * 
	 * MyBuyProductListCount(String status, String id) : 특정 상태인 구매목록 수
	 * 
	 * 
	 * @param status
	 * @param id
	 * @return
	 * @throws SQLException
	 */

	public int myBuyProductListCount(String status, String id) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "select count(*) from buy_product_list where id=? and status=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, status);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return result;
	}

	/**
	 * MyBuyProductListTotal(String id) : 나의 구매목록 전체 불러오기
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */

	public ArrayList<BuyProductVO> myBuyProductListTotal(String id) throws SQLException {
		ArrayList<BuyProductVO> list = new ArrayList<>();
		BuyProductVO buyProductVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sb= new StringBuilder("select b.id, b.post_no,b.ns_date,b.status,b.amount, p.title ");
			sb.append("from (select * from buy_product_list where id=?) b ");
			sb.append("inner join NongShim_product_Post p on b.post_no=p.post_no order by ns_date desc");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				buyProductVO = new BuyProductVO(rs.getString(1), rs.getLong(2), rs.getString(3), rs.getString(4),
						rs.getLong(5),rs.getString(6));
				list.add(buyProductVO);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}

	/**
	 * InsertSellerCheck(SellerIdeVO sellerIdeVO) : 판매자 인증 버튼 클릭 후 사업자 번호를 등록 할때
	 * 사용하는 메서드 아이디와 사업자 인증번호를 입력 받아 seller_ide 테이블에 insert 한다 유일값에 특정 값 보다 작으면
	 * block 10자리(jsp)
	 * 
	 * @param id
	 * @param sellerNum
	 * @return
	 * @throws SQLException
	 */
	public boolean insertSellerCheck(SellerIdeVO sellerIdeVO) throws SQLException {
		boolean flag = false;
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "insert into seller_ide values(?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sellerIdeVO.getId());
			pstmt.setString(2, sellerIdeVO.getCompanyRegisterNum());
			result = pstmt.executeUpdate();
			if (result > 0) {
				flag = true;
				sellercheckUpdate(sellerIdeVO.getId());
			}
		} finally {
			closeAll(pstmt, con);
		}
		return flag;
	}

	/**
	 * sellerCheck(String id) : 아이디를 통해서 seller_ide의 정보를 불러옴
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public SellerIdeVO sellerCheck(String id) throws SQLException {
		SellerIdeVO sellerIdeVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "select * from seller_ide where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				sellerIdeVO = new SellerIdeVO(rs.getString(1), rs.getString(2));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return sellerIdeVO;
	}
	
	/**
	 * sellerNumberCheck : 해당 번호 ajax view로 던져주기 위해 만듬
	 * @param sellerNumber
	 * @return
	 * @throws SQLException
	 */
	
	public boolean sellerNumberCheck(String sellerNumber) throws SQLException {
		boolean flag=false;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "select * from seller_ide where company_register_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sellerNumber);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				flag=true; 
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return flag;
	}
	
	

	/**
	 * 
	 * sellercheckUpdate(String id) : seller_ide에 정보가 저장되면 동시에 update 됨
	 * InsertSellerCheck 가 true 상태이면 업데이트 됨
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */

	public boolean sellercheckUpdate(String id) throws SQLException {
		boolean flag = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			con = dataSource.getConnection();
			String sql = "update NongShim_Member set seller_info='판매자' where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
			if (result > 0) {
				flag = true;
			}
		} finally {
			closeAll(pstmt, con);
		}
		return flag;
	}

	/**
	 * 
	 * AdministratorCheck(String id) : 체크만 하면 됨 seller_ide member 테이블의 정보를 가져와서 id와
	 * 관리자 정보를 가져옴
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 * 
	 */
	public MyPageMemberVO administratorCheck(String id) throws SQLException {
		MyPageMemberVO myPageMemberVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "select id,admin_INfo from NongShim_Member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				myPageMemberVO = new MyPageMemberVO(rs.getString(1), rs.getString(2));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return myPageMemberVO;
	}

	/**
	 * ConfirmListbyIdandPostNo(String postNo): 구매자 목록을 불러오는 메서드 
	 * 																		order by가 되어있지 않음
	 * @param postNo
	 * @return
	 * @throws SQLException
	 */
	
	public ArrayList<ConfirmListVO> confirmListbyIdandPostNo(String postNo) throws SQLException {
		ArrayList<ConfirmListVO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			 String sql="select c.id, m.name, c.product_amount, c.post_status, m.address, m.tel,post_no from confirm_list c inner join  NongShim_Member m on c.id=m.id where post_no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,postNo);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				ConfirmListVO confirmList= new ConfirmListVO(rs.getString(1),rs.getString(2),rs.getLong(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
				list.add(confirmList);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	/**
	 * 		myFavoriteList(String id) : 내가 좋아요한 목록 가져오기
	 * @param id
	 * @return 
	 * @throws SQLException 
	 */
	public ArrayList<MyPageProductPostVO> myFavoriteList(String id) throws SQLException {
		ArrayList<MyPageProductPostVO> list=new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con=dataSource.getConnection();
			//테스트 해봄 근데 구매자 목록 처럼 되어야 하는데 안되는 중 ^^; 나중에 테스트 다시 해보길 --> 완료
			StringBuilder sb=new StringBuilder("select c.post_no, p.title, p.id, p.category, p.status, p.duration, p.min_Customer, p.max_Customer ");
			sb.append("from (select * from like_product where id=?) c ");
			sb.append("inner join NongShim_product_Post p on p.post_no=c.post_no");
			pstmt=con.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				MyPageProductPostVO productVO=new MyPageProductPostVO(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getLong(7),rs.getLong(8));
				list.add(productVO);
				//System.out.println(productVO);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	
	/**
	 * 	insertNsPoint(String id, long point) : 자유게시판에 글이나 댓글이 등록 되었을 때 포인트를 등록하게 하는 메서드
	 * 
	 * @param id
	 * @param point
	 * @throws SQLException
	 */

	public long insertNsPoint(String id, long point) throws SQLException {
		long result=0;

		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			con=dataSource.getConnection();
			String sql="update NongShim_Member set point=point+? where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setLong(1, point);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
			pstmt.close();
			String sql2="select point from NongShim_Member where id=?";
			pstmt=con.prepareStatement(sql2);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=rs.getLong(1);
			}
		} finally {
			closeAll(pstmt, con);
		}
		return result;
	}
	
	/**
	 *  randomPointNumber() : 로또복권에 쓸 메서드
	 *  5등부터 1등까지 저장 - > controller에서 각자 불러와서 "5" "4" "3" "2" "1"로 불러오기?
	 * @return
	 */

	public TreeSet<Integer> randomPointNumber() {
		TreeSet<Integer> set=new TreeSet<>();
		Random random=new Random();
		boolean flag=true;
		int num=0;
		while(flag) {
		for(int i=0;i<5;i++) {
			num=random.nextInt(1000);
			set.add(num);
			//System.out.println("출력");
			//System.out.println(num);
			if(set.size()==5) {
				flag=false;
			}
			}
		}
		return set;
	}
	
	
	
}
