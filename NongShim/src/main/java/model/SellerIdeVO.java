package model;

public class SellerIdeVO {
	private String id;
	private String companyRegisterNum;
	public SellerIdeVO() {
		super();
	}
	public SellerIdeVO(String id, String companyRegisterNum) {
		super();
		this.id = id;
		this.companyRegisterNum = companyRegisterNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCompanyRegisterNum() {
		return companyRegisterNum;
	}
	public void setCompanyRegisterNum(String companyRegisterNum) {
		this.companyRegisterNum = companyRegisterNum;
	}
	@Override
	public String toString() {
		return "SellerIdeVO [id=" + id + ", companyRegisterNum=" + companyRegisterNum + "]";
	}
	
}
