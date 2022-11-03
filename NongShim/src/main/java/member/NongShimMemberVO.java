package member;

import java.io.Serializable;

public class NongShimMemberVO implements Serializable{
	private static final long serialVersionUID = 4881778484582860292L;
	private String id;
	private String name;
	private String password;
	private String address;
	private String nickName;
	private String tel;
	private String sellerInfo;
	private String adminiInfo;
	private String email;
	private int point;
	private String accountNo ;
	public NongShimMemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NongShimMemberVO(String id, String name, String password, String address, String nickName, String tel,
			String sellerInfo, String adminiInfo, String email, int point, String accountNo) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.address = address;
		this.nickName = nickName;
		this.tel = tel;
		this.sellerInfo = sellerInfo;
		this.adminiInfo = adminiInfo;
		this.email = email;
		this.point = point;
		this.accountNo = accountNo;
	}
	
	//로그인 생성자
	public NongShimMemberVO(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	public NongShimMemberVO(String id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}
	
	
	public NongShimMemberVO(String id, String name, String password, String address, String nickName, String tel,
			String email) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.address = address;
		this.nickName = nickName;
		this.tel = tel;
		this.email = email;
	}
	
	
	//회원가입 생성자
	public NongShimMemberVO(String id, String name, String password, String address, String nickName, String tel,
			String email, int point, String accountNo) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.address = address;
		this.nickName = nickName;
		this.tel = tel;
		this.email = email;
		this.point = point;
		this.accountNo = accountNo;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getSellerInfo() {
		return sellerInfo;
	}
	public void setSellerInfo(String sellerInfo) {
		this.sellerInfo = sellerInfo;
	}
	public String getAdminiInfo() {
		return adminiInfo;
	}
	public void setAdminiInfo(String adminiInfo) {
		this.adminiInfo = adminiInfo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	
}
