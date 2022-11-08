package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class ProductPostDAO {
	private static ProductPostDAO instance = new ProductPostDAO();
	private DataSource dataSource;

	private ProductPostDAO() {
		dataSource = DataSourceManager.getInstance().getDataSource();
	}

	public static ProductPostDAO getInstance() {
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

	public ProductPostVO postDetailFind(long no) throws SQLException {
		// 제목부분을 클릭한다고 가정
		// 누르면 조회수도 하나 올려주고.
		// updateHits도 만들어야할듯
		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection con = null;
		ProductPostVO pp = new ProductPostVO();

		try {
			con = getConnection();
			String sql = "select title,content, hits,nickname,comments,register_date,category,product_name,product_point,to_char(duration, 'YYYY-MM-DD') AS duration,min_customer,max_customer, id from NongShim_product_Post where post_no=?";
			pst = con.prepareStatement(sql);
			pst.setLong(1, no);
			rs = pst.executeQuery();
			if (rs.next()) {
				String title = rs.getString(1);
				String content = rs.getString(2);
				long hits = rs.getLong(3);
				String nick = rs.getString(4);
				String comments = rs.getString(5);
				String regdate = rs.getString(6);
				String category = rs.getString(7);
				String pname = rs.getString(8);
				long ppoint = rs.getLong(9);
				String duration = rs.getString(10);
				long mincustomer = rs.getLong(11);
				long maxcustomer = rs.getLong(12);
				String id = rs.getString(13);
				pp = new ProductPostVO(no, title, content, hits, nick, comments, regdate, category, pname, ppoint,
						duration, mincustomer, maxcustomer, id);
			}
		} finally {
			closeAll(rs, pst, con);
		}

		return pp;
	}

	public void writePost(ProductPostVO productpostVO) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "INSERT INTO NongShim_product_Post VALUES (postNo_seq.nextval,?,?,?,default,?,?,sysdate,?,?,?,?,?,?,? )";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, productpostVO.getTitle());
			pstmt.setString(2, productpostVO.getContent());
			pstmt.setString(3, productpostVO.getId());
			pstmt.setString(4, productpostVO.getNickName());
			pstmt.setString(5, productpostVO.getComments());
			pstmt.setString(6, productpostVO.getCategory());
			pstmt.setString(7, productpostVO.getStatus());
			pstmt.setString(8, productpostVO.getProductName());
			pstmt.setLong(9, productpostVO.getProductPoint());
			pstmt.setDate(10, Date.valueOf(productpostVO.getDuration()));
			pstmt.setLong(11, productpostVO.getMinCustomer());
			pstmt.setLong(12, productpostVO.getMaxCustomer());
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}

	public void updatePost(ProductPostVO productpostVO) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con=dataSource.getConnection();
			String sql="update NongShim_product_Post set title=?,content=?,category=?,product_Point=?, duration=?, min_Customer=?,max_Customer=? where post_No=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,productpostVO.getTitle());
			pstmt.setString(2,productpostVO.getContent());
			pstmt.setString(3,productpostVO.getCategory());
			pstmt.setLong(4,productpostVO.getProductPoint());
			pstmt.setDate(5,Date.valueOf(productpostVO.getDuration()));
			pstmt.setLong(6,productpostVO.getMinCustomer());
			pstmt.setLong(7,productpostVO.getMaxCustomer());
			pstmt.setLong(8,productpostVO.getPostNo());
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}

	public void deletePost(long no) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "DELETE NongShim_product_Post WHERE post_No=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, no);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}

	public void addCommentInMoon(String id, long postno, String comment) throws SQLException {
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = getConnection();
			String sql = "insert into NONGSHIM_PRODUCTPOSTCOMMENTS values (?,?,sysdate,?,'문의',product_comment_seq.nextval)";
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			pst.setLong(2, postno);
			pst.setString(3, comment);
			pst.executeUpdate();
		} finally {
			closeAll(pst, con);
		}
	}

	public void addCommentInHoo(String id, long postno, String comment) throws SQLException {
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = getConnection();
			String sql = "insert into NONGSHIM_PRODUCTPOSTCOMMENTS values (?,?,sysdate,?,'후기',product_comment_seq.nextval)";
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			pst.setLong(2, postno);
			pst.setString(3, comment);
			pst.executeUpdate();
		} finally {
			closeAll(pst, con);
		}
	}


	
	public ArrayList<CommentVO> showAllCommentByPostNo(long postno, String mode) throws SQLException {
		ArrayList<CommentVO> list = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = getConnection();
			String sql = null;
			if(!mode.equals("all")) {
				sql= "select post_No, content,category,id,to_char(comments_date,'YYYY-MM-DD HH24:MI') AS comments_date,comment_No from NongShim_productPostComments where post_no=? AND category = ? ORDER BY comments_date DESC";
				pst = con.prepareStatement(sql);
				pst.setLong(1, postno);
				pst.setString(2, mode);
			} else {
				sql = "select post_No, content,category,id,to_char(comments_date,'YYYY-MM-DD HH24:MI') AS comments_date,comment_No from NongShim_productPostComments where post_no=? ORDER BY comments_date DESC";
				pst = con.prepareStatement(sql);
				pst.setLong(1, postno);
			}
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new CommentVO(rs.getString(4), rs.getLong(1), rs.getString(5), rs.getString(2),
						rs.getString(3),rs.getLong(6)));
			}
		} finally {
			closeAll(rs, pst, con);
		}
		return list;
	}

	public void updateComment(long comment_No, String content) throws SQLException {
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = getConnection();
			String sql = "update NONGSHIM_PRODUCTPOSTCOMMENTS set content = ? where id=? and post_no=? and comments_date=?";
			pst = con.prepareStatement(sql);
			pst.setLong(1, comment_No);
			pst.setString(2, content);
			pst.executeUpdate();

		} finally {
			closeAll(pst, con);
		}
	}

	public void deleteComment(long comment_No) throws SQLException {
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = getConnection();
			String sql = "delete from NongShim_productPostComments where comment_No = ?";
			pst = con.prepareStatement(sql);
			pst.setLong(1, comment_No);
			pst.executeUpdate();
		} finally {
			closeAll(pst, con);
		}

	}

	public boolean buyProduct(String id, Long post_No) throws SQLException {
		boolean result = false;
		int rs;
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = getConnection();
			String sql = "INSERT INTO buy_product_list VALUES (?,?,sysdate,DEFAULT,DEFAULT)";
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			pst.setLong(2, post_No);
			rs = pst.executeUpdate();
			pst.close();
			sql = "INSERT INTO confirm_list VALUES(?,?,DEFAULT,DEFAULT,DEFAULT)";
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			pst.setLong(2, post_No);
			rs = pst.executeUpdate();
			if(rs==1) {
				result = true;
			}
		} finally {
			closeAll(pst, con);
		}
		return result;
	}

	public int getTotalPostCount() throws SQLException {
		// 데이터베이스의 NongShim_productPost 테이블의 총 개시물 수를 불러옴
		// 입력값: 없음
		// 출력값: 총 게시물 수
		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection con = null;
		int totalpostcount = 0;
		try {
			con = getConnection();
			String sql = "SELECT COUNT(*) FROM NongShim_product_Post";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs.next()) {
				totalpostcount = rs.getInt(1);
			}
		} finally {
			closeAll(rs, pst, con);
		}
		return totalpostcount;
	}

	public int getTotalPostCountValue(String checkbox) throws SQLException {
		// 데이터베이스의 NongShim_productPost 테이블의 총 개시물 수를 불러옴
		// 입력값: 없음
		// 출력값: 총 개시물 수
		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection con = null;
		int totalpostcount = 0;
		try {
			con = getConnection();
			String sql = "SELECT COUNT(*) FROM NongShim_product_Post WHERE category = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, checkbox);
			rs = pst.executeQuery();
			if (rs.next()) {
				totalpostcount = rs.getInt(1);
			}
		} finally {
			closeAll(rs, pst, con);
		}
		return totalpostcount;
	}

	public int getTotalPostCountSearch(String inputvalue) throws SQLException {
		// 데이터베이스의 NongShim_productPost 테이블의 총 개시물 수를 불러옴
		// 입력값: 없음
		// 출력값: 총 개시물 수
		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection con = null;
		int totalpostcount = 0;
		try {
			con = getConnection();
			String sql = "SELECT COUNT(*) FROM NongShim_product_Post WHERE title like ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, '%' + inputvalue + '%');
			rs = pst.executeQuery();
			if (rs.next()) {
				totalpostcount = rs.getInt(1);
			}
		} finally {
			closeAll(rs, pst, con);
		}
		return totalpostcount;
	}

	public ArrayList<ProductPostVO> findPostListByCheckbox(Pagination pagination, String checkbox) throws SQLException {
		// pagination의 시작값과 끝값을 바탕으로 NongShim_productPost에서 정해진 개수만큼의 게시글을 불러옴
		// 입력값: pagination
		// 출력값: 페이지 정보인 productpostvo 가 담긴 list를 반환
		ArrayList<ProductPostVO> list = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = getConnection();
			StringBuilder sb = new StringBuilder("");
			sb.append(
					"SELECT rownum, post_No, title, hits, TO_CHAR(register_Date, 'YYYY-MM-DD') AS register_Date, category, nickname, status ");
			sb.append("FROM NongShim_product_Post ");
			sb.append("WHERE category = ? AND rownum BETWEEN ? AND ?");
			pst = con.prepareStatement(sb.toString());
			pst.setString(1, checkbox);
			pst.setLong(2, pagination.getStartRowNumber());
			pst.setLong(3, pagination.getEndRowNumber());
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new ProductPostVO(rs.getLong(2), rs.getString(3), rs.getLong(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8)));
				System.out.println(rs.getLong(2) + rs.getString(3) + rs.getLong(4) + rs.getString(5) + rs.getString(6)
						+ rs.getString(7) + rs.getString(8));
			}
		} finally {
			closeAll(rs, pst, con);
		}
		return list;
	}

	public ArrayList<ProductPostVO> findPostListByValue(Pagination pagination, String value) throws SQLException {
		// pagination의 시작값과 끝값을 바탕으로 NongShim_productPost에서 정해진 개수만큼의 게시글을 불러옴
		// 입력값: pagination
		// 출력값: 페이지 정보인 productpostvo 가 담긴 list를 반환
		ArrayList<ProductPostVO> list = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = getConnection();
			StringBuilder sb = new StringBuilder("");
			sb.append("SELECT post_No, title, hits, register_Date, category, nickname, status ");
			sb.append("FROM (SELECT row_number() over(ORDER BY post_No DESC) AS rnum, ");
			sb.append(
					"post_No, title, hits, TO_CHAR(register_Date, 'YYYY-MM-DD') AS register_Date, category, nickname, status ");
			sb.append("FROM NongShim_product_post ");
			if (value == null) {
				sb.append(") WHERE rnum BETWEEN ? AND ?");
				pst = con.prepareStatement(sb.toString());
				pst.setLong(1, pagination.getStartRowNumber());
				pst.setLong(2, pagination.getEndRowNumber());
			} else if (value.equals("곡물") | value.equals("과일") | value.equals("야채")) {
				sb.append("WHERE category = ?) WHERE rnum BETWEEN ? AND ?");
				pst = con.prepareStatement(sb.toString());
				pst.setString(1, value);
				pst.setLong(2, pagination.getStartRowNumber());
				pst.setLong(3, pagination.getEndRowNumber());
			} else {
				sb.append(") WHERE rnum BETWEEN ? AND ?");
				pst = con.prepareStatement(sb.toString());
				pst.setLong(1, pagination.getStartRowNumber());
				pst.setLong(2, pagination.getEndRowNumber());
			}
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new ProductPostVO(rs.getLong(1), rs.getString(2), rs.getLong(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7)));
			}
		} finally {
			closeAll(rs, pst, con);
		}
		return list;
	}

	public ArrayList<ProductPostVO> findPostListBySearch(Pagination pagination, String inputvalue) throws SQLException {
		// pagination의 시작값과 끝값을 바탕으로 NongShim_productPost에서 정해진 개수만큼의 게시글을 불러옴
		// 입력값: pagination, 검색창에 넣은 검색값
		// 출력값: 검색 단어가 제목에 포함된 페이지 정보인 productpostvo 가 담긴 list를 반환
		ArrayList<ProductPostVO> list = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = getConnection();
			StringBuilder sb = new StringBuilder("");
			sb.append("SELECT post_No, title, hits, register_Date, category, nickname, status ");
			sb.append("FROM (SELECT row_number() over(ORDER BY post_No DESC) AS rnum, ");
			sb.append(
					"post_No, title, hits, TO_CHAR(register_Date, 'YYYY-MM-DD') AS register_Date, category, nickname, status ");
			sb.append("FROM NongShim_product_post ");
			sb.append("WHERE title LIKE ?) WHERE rnum BETWEEN ? AND ?");
			pst = con.prepareStatement(sb.toString());
			pst.setString(1, '%' + inputvalue + '%');
			pst.setLong(2, pagination.getStartRowNumber());
			pst.setLong(3, pagination.getEndRowNumber());
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new ProductPostVO(rs.getLong(1), rs.getString(2), rs.getLong(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7)));
			}
		} finally {
			closeAll(rs, pst, con);
		}
		return list;
	}

	public void updateHits(long postno) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "UPDATE NongShim_product_Post SET hits=hits+1 WHERE post_No=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, postno);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}


	public void likePostPush(long postno, String id) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "insert into LIKE_PRODUCT values(?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, postno);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}

	}

	public long showTotalLike(long postno) throws SQLException {
		long totalLikes = 0;
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "select count(*) from LIKE_PRODUCT where post_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, postno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				totalLikes = rs.getLong(1);
			}
		} finally {
			closeAll(rs,pstmt, con);
		}
		return totalLikes;
	}

	public void likeCancel(long postno, String id) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "delete from LIKE_PRODUCT where post_no=? and id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, postno);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}

	}
	//반환값이 true이면 이미 좋아요 누른거 false이면 좋아요 한적 없는거.
	public boolean checkLikes(long postno, String id) throws SQLException {
        boolean check=false;
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "select * from LIKE_PRODUCT where post_no=? and id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, postno);
			pstmt.setString(2, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				check=true;
			}else {
				check=false;
			}
		} finally {
			closeAll(rs,pstmt, con);
		}
		return check;

	}
}
