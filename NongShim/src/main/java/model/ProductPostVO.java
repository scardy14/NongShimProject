package model;

public class ProductPostVO {
	private long postNo;
	private String title;
	private String content;
	private String id;
	private long hits;
	private String nickName;
	private String comments;
	private String date;
	private String category;
	private String status;
	private String productName;
	private long productPoint;
	private String duration;
	private long minCustomer;
	private long maxCustomer;
	
	public ProductPostVO() {
		super();
	}

	public ProductPostVO(long postNo, String title, String content, String id, long hits, String nickName,
			String comments, String date, String category, String status, String productName, long productPoint,
			String duration, long minCustomer, long maxCustomer) {
		super();
		this.postNo = postNo;
		this.title = title;
		this.content = content;
		this.id = id;
		this.hits = hits;
		this.nickName = nickName;
		this.comments = comments;
		this.date = date;
		this.category = category;
		this.status = status;
		this.productName = productName;
		this.productPoint = productPoint;
		this.duration = duration;
		this.minCustomer = minCustomer;
		this.maxCustomer = maxCustomer;
	}

	@Override
	public String toString() {
		return "ProductPostVO [postNo=" + postNo + ", title=" + title + ", content=" + content + ", id=" + id
				+ ", hits=" + hits + ", nickName=" + nickName + ", comments=" + comments + ", date=" + date
				+ ", category=" + category + ", status=" + status + ", productName=" + productName + ", productPoint="
				+ productPoint + ", duration=" + duration + ", minCustomer=" + minCustomer + ", maxCustomer="
				+ maxCustomer + "]";
	}
	










}

