package model;

public class BuyProductVO {
	private Long rnum;
	private String id;
	private long postNo;
	private String nsDate;
	private String status;
	private long amount;
	private String title;
	public BuyProductVO() {
		super();
	}
	public BuyProductVO(String id, long postNo, String nsDate, String status, long amount, String title) {
		super();
		this.id = id;
		this.postNo = postNo;
		this.nsDate = nsDate;
		this.status = status;
		this.amount = amount;
		this.title = title;
	}
	
	public BuyProductVO(Long rnum, String id, long postNo, String nsDate, String status, long amount, String title) {
		super();
		this.rnum = rnum;
		this.id = id;
		this.postNo = postNo;
		this.nsDate = nsDate;
		this.status = status;
		this.amount = amount;
		this.title = title;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Long getRnum() {
		return rnum;
	}
	public void setRnum(Long rnum) {
		this.rnum = rnum;
	}
	@Override
	public String toString() {
		return "BuyProductVO [id=" + id + ", postNo=" + postNo + ", nsDate=" + nsDate + ", status=" + status
				+ ", amount=" + amount + ", title=" + title + "]";
	}

}
