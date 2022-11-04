package model;

public class BuyProductVO {
	private String id;
	private long postNo;
	private String nsDate;
	private String status;
	private long amount;
	public BuyProductVO() {
		super();
	}
	public BuyProductVO(String id, long postNo, String nsDate, String status, long amount) {
		super();
		this.id = id;
		this.postNo = postNo;
		this.nsDate = nsDate;
		this.status = status;
		this.amount = amount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getPostNo() {
		return postNo;
	}
	public void setPostNo(long postNo) {
		this.postNo = postNo;
	}
	public String getNsDate() {
		return nsDate;
	}
	public void setNsDate(String nsDate) {
		this.nsDate = nsDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "BuyProductVO [id=" + id + ", postNo=" + postNo + ", nsDate=" + nsDate + ", status=" + status
				+ ", amount=" + amount + "]";
	}

}
