package model;

public class ProductPostVO {
	private long postNo;
	private String title;
	private String content;
	private String id;
	private long hits;
	private String nickName;
	private String comments;
	private String date; //이거 등록하는 날짜
	private String category;
	private String status;
	private String productName;
	private long productPoint;
	private String duration; //마감까지 날짜.
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
	//홍주영 개인적으로 만든거. 게시물 리스트 보여줄 떄 필요한 요소로 게시물번호, 제목, 조회수, 날짜, 카테고리, 닉네임, 상태값을 가져옴
	//이거 삭제하면 당장 공구게시판 안돌아가니 일단 내둘것.
	public ProductPostVO(long postNo, String title, long hits, String date, String category, String nickname, String status) {
		super();
		this.postNo = postNo;
		this.title = title;
		this.hits = hits;
		this.date = date;
		this.category = category;
		this.status = status;
		this.nickName = nickname;
	}
	
	//김민석 개인적으로 만든거. 위와 같은 이유로 냅둘것.
	
	public ProductPostVO(String title, String content, long hits, String nickName, String comments, String date,
			String category, String productName, long productPoint, String duration, long minCustomer,
			long maxCustomer) {
		super();
		this.title = title;
		this.content = content;
		this.hits = hits;
		this.nickName = nickName;
		this.comments = comments;
		this.date = date;
		this.category = category;
		this.productName = productName;
		this.productPoint = productPoint;
		this.duration = duration;
		this.minCustomer = minCustomer;
		this.maxCustomer = maxCustomer;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getHits() {
		return hits;
	}

	public void setHits(long hits) {
		this.hits = hits;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getProductPoint() {
		return productPoint;
	}

	public void setProductPoint(long productPoint) {
		this.productPoint = productPoint;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public long getMinCustomer() {
		return minCustomer;
	}

	public void setMinCustomer(long minCustomer) {
		this.minCustomer = minCustomer;
	}

	public long getMaxCustomer() {
		return maxCustomer;
	}

	public void setMaxCustomer(long maxCustomer) {
		this.maxCustomer = maxCustomer;
	}
	










}

