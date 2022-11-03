package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;


import model.DataSourceManager;



public class NongShimMemberDAO {
	private static NongShimMemberDAO instance=new NongShimMemberDAO();
	private DataSource dataSource;
	private NongShimMemberDAO() {
		dataSource=DataSourceManager.getInstance().getDataSource();
	}
	public static NongShimMemberDAO getInstance() {
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
	
	public NongShimMemberVO login(String id, String password) throws SQLException{
		NongShimMemberVO nongShimMemberVO=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			String sql="select id,password,name from NongShim_Member where id=? and password=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			if(rs.next()) {
			 nongShimMemberVO=new NongShimMemberVO(id,rs.getString(2),password);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return nongShimMemberVO;
	}	
	public void registerMember(NongShimMemberVO vo) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=getConnection();
			String sql="insert into NongShim_Member values(?,?,?,?,?,?,DEFAULT,DEFAULT,?,default,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getAddress());
			pstmt.setString(5, vo.getNickName());
			pstmt.setString(6,vo.getTel());
			pstmt.setString(7,vo.getEmail());
			pstmt.setString(8,vo.getAccountNo());
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
	}
	
	public boolean checkId(String id) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		boolean result=false;
		try {
			con=getConnection();
			String sql="select count(*) from NongShim_Member where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()&&rs.getInt(1)>0) {
				result=true;
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return result;
	}
	
	public boolean checkTel(int tel) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		boolean result=false;
		try {
			con=getConnection();
			String sql="select count(*) from NongShim_Member where tel=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, tel);
			rs=pstmt.executeQuery();
			if(rs.next()&&rs.getInt(1)>0) {
				result=true;
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return result;
	}
	
	public boolean check_account_No(String account_No) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		boolean result=false;
		try {
			con=getConnection();
			String sql="select count(*) from NongShim_Member where account_No=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, account_No);
			rs=pstmt.executeQuery();
			if(rs.next()&&rs.getInt(1)>0) {
				result=true;
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return result;
	}
	public boolean checkEmail(String email) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		boolean result=false;
		try {
			con=getConnection();
			String sql="select count(*) from NongShim_Member where email=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs=pstmt.executeQuery();
			if(rs.next()&&rs.getInt(1)>0) {
				result=true;
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return result;
	}
	public boolean checkNickName(String nickName) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		boolean result=false;
		try {
			con=getConnection();
			String sql="select count(*) from NongShim_Member where nickName=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, nickName);
			rs=pstmt.executeQuery();
			if(rs.next()&&rs.getInt(1)>0) {
				result=true;
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return result;
	}
	
	
}
