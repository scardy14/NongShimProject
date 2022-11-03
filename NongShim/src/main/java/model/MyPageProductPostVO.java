package model;

public class MyPageProductPostVO {
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

	@Override
	public String toString() {
		return "ProductPostVO [postNo=" + postNo + ", title=" + title + ", content=" + content + ", id=" + id
				+ ", hits=" + hits + ", nickName=" + nickName + ", comments=" + comments + ", date=" + date
				+ ", category=" + category + ", status=" + status + ", productName=" + productName + ", productPoint="
				+ productPoint + ", duration=" + duration + ", minCustomer=" + minCustomer + ", maxCustomer="
				+ maxCustomer + "]";
	}
	
}
