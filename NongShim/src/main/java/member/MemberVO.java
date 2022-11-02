package member;

import java.io.Serializable;

public class MemberVO implements Serializable{
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
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberVO(String id, String name, String password, String address, String nickName, String tel,
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
	
	
}
