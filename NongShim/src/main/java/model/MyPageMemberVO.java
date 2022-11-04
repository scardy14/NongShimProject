package model;

import java.io.Serializable;

public class MyPageMemberVO implements Serializable{
	private static final long serialVersionUID = 4881778484582860292L;
	private String id;//아이디
	private String name;//이름
	private String password;//비번
	private String address;//주소
	private String nickName;//닉네임
	private String tel;//전화번호
	private String sellerInfo;//판매자인증
	private String adminiInfo;//인증정보
	private String email;//이메일
	private int point;//포인트
	private String accountNo;//계좌번호
	public MyPageMemberVO() {
		super();
	}
	public MyPageMemberVO(String id, String adminiInfo) {
		super();
		this.id = id;
		this.adminiInfo = adminiInfo;
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
	@Override
	public String toString() {
		return "MyPageMemberVO [id=" + id + ", name=" + name + ", password=" + password + ", address=" + address
				+ ", nickName=" + nickName + ", tel=" + tel + ", sellerInfo=" + sellerInfo + ", adminiInfo="
				+ adminiInfo + ", email=" + email + ", point=" + point + ", accountNo=" + accountNo + "]";
	}
	
	
}
