package model;

public class MyPageProductPostVO {
	private long rnum;
	private long postNo; // 글번호
	private String title; // 글제목
	private String content; //글내용
	private String id; //id
	private long hits; //조회수
	private String nickName; //닉네임
	private String comments; //댓글
	private String date; //작성일
	private String category; //카테고리 '과일','채소','곡물'
	private String status; //상태 '판매중','판매완료'
	private String productName; // 상품명
	private long productPoint; // 상품 가격 -> 포인트로 결제하므로
	private String duration; //판매기간
	private long minCustomer; //최소 구매 인원
	private long maxCustomer; //최대 구매 인원
	
	public MyPageProductPostVO() {
		super();
	}
	
	

	public MyPageProductPostVO(long rnum, long postNo, String title, String content, String id, long hits,
			String nickName, String comments, String date, String category, String status, String productName,
			long productPoint, String duration, long minCustomer, long maxCustomer) {
		super();
		this.rnum = rnum;
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



	public MyPageProductPostVO(long postNo, String title, String content, String id, long hits, String nickName,
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
	
	//mySellProductListTotal(id)
	public MyPageProductPostVO(long rnum, long postNo, String title, String id, String date, String status, String duration,
			long minCustomer, long maxCustomer, long productPoint) {
		super();
		this.rnum = rnum;
		this.postNo = postNo;
		this.title = title;
		this.id = id;
		this.date = date;
		this.status = status;
		this.duration = duration;
		this.minCustomer = minCustomer;
		this.maxCustomer = maxCustomer;
		this.productPoint = productPoint;
	}

	//MySellProductList : '판매중' 또는 '판매 종료' 목록
	public MyPageProductPostVO(long postNo, String id, String date, String category, String status, String productName,
			long productPoint, String duration, long minCustomer, long maxCustomer) {
		super();
		this.postNo = postNo;
		this.id = id;
		this.date = date;
		this.category = category;
		this.status = status;
		this.productName = productName;
		this.productPoint = productPoint;
		this.duration = duration;
		this.minCustomer = minCustomer;
		this.maxCustomer = maxCustomer;
	}
	
	
	//좋아요 목록에 사용할 생성자
	public MyPageProductPostVO(long postNo, String title, String id, String category, String status, String duration,
			long minCustomer, long maxCustomer) {
		super();
		this.postNo = postNo;
		this.title = title;
		this.id = id;
		this.category = category;
		this.status = status;
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
	
	public Long getRnum() {
		return rnum;
	}

	public void setRnum(Long rnum) {
		this.rnum = rnum;
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
