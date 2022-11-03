package model;

public class BuyProductVO {
	private String id;
	private long nsDate;
	private long postNo;
	private String status;
	private long amount;
	public BuyProductVO() {
		super();
	}
	public BuyProductVO(String id, long nsDate, long postNo, String status, long amount) {
		super();
		this.id = id;
		this.nsDate = nsDate;
		this.postNo = postNo;
		this.status = status;
		this.amount = amount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getNsDate() {
		return nsDate;
	}
	public void setNsDate(long nsDate) {
		this.nsDate = nsDate;
	}
	public long getPostNo() {
		return postNo;
	}
	public void setPostNo(long postNo) {
		this.postNo = postNo;
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
		return "BuyProductVO [id=" + id + ", nsDate=" + nsDate + ", postNo=" + postNo + ", status=" + status
				+ ", amount=" + amount + "]";
	}
	
}
