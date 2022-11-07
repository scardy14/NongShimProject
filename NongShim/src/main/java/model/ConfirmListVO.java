package model;

public class ConfirmListVO {
	private String id;
	private String name;
	private long amount;
	private String status;
	private String address;
	private String tel;
	public ConfirmListVO() {
		super();
	}
	public ConfirmListVO(String id, String name, long amount, String status, String address, String tel) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.status = status;
		this.address = address;
		this.tel = tel;
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
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "ConfirmListVO [id=" + id + ", name=" + name + ", amount=" + amount + ", status=" + status + ", address="
				+ address + ", tel=" + tel + "]";
	}
}
