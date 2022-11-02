package model;

public class ProductPostVO {
	private long postNo;
	private String title;
	private String content;
	private long hits;
	private String comment;
	private String date;
	private String category;
	private String nickName;
	private String id;
	private String status;
	
	public ProductPostVO() {}
	
	
	
	public ProductPostVO(long postNo, String title, long hits, String date, String category, String nickName,
			String status) {
		super();
		this.postNo = postNo;
		this.title = title;
		this.hits = hits;
		this.date = date;
		this.category = category;
		this.nickName = nickName;
		this.status = status;
	}



	public ProductPostVO(long postNo, String title, String content, long hits, String comment, String date,
			String category, String nickName, String id, String status) {
		super();
		this.postNo = postNo;
		this.title = title;
		this.content = content;
		this.hits = hits;
		this.comment = comment;
		this.date = date;
		this.category = category;
		this.nickName = nickName;
		this.id = id;
		this.status = status;
	}

	public long getPostNo() {
		return postNo;
	}

	public void setPostNo(long postNo) {
		this.postNo = postNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getHits() {
		return hits;
	}

	public void setHits(long hits) {
		this.hits = hits;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ProductPostVO [postNo=" + postNo + ", title=" + title + ", content=" + content + ", hits=" + hits
				+ ", comment=" + comment + ", date=" + date + ", category=" + category + ", nickName=" + nickName
				+ ", id=" + id + ", status=" + status + "]";
	};
	
	
	

}
