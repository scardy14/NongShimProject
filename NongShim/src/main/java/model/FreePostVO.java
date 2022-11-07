package model;

public class FreePostVO { 
	private Long post_No;
	private String id;
	private String title;
	private String content;
	private	Long hits;
	private String nickname;
	private String regitster_Date;
	private String category;
	public FreePostVO() {
		super();
		
	}
	// 게시글 상세보기
	public FreePostVO(Long post_No, String id, String title, String content, Long hits, String nickname,
			String regitster_Date, String category) {
		super();
		this.post_No = post_No;
		this.id = id;
		this.title = title;
		this.content = content;
		this.hits = hits;
		this.nickname = nickname;
		this.regitster_Date = regitster_Date;
		this.category = category;
	}
	//게시글 리스트
	public FreePostVO(Long post_No, String title, Long hits, String nickname, String regitster_Date, String category) {
		super();
		this.post_No = post_No;
		this.title = title;
		this.hits = hits;
		this.nickname = nickname;
		this.regitster_Date = regitster_Date;
		this.category = category;
	}
	// 게시글 작성
	public FreePostVO(String id, String title, String content, String nickname, String category) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.nickname = nickname;
		this.category = category;
	}
	// 게시글 데이터 이동
	public FreePostVO(Long post_No, String title, String content) {
		super();
		this.post_No = post_No;
		this.title = title;
		this.content = content;
	}
	public Long getPost_No() {
		return post_No;
	}
	public void setPost_No(Long post_No) {
		this.post_No = post_No;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public Long getHits() {
		return hits;
	}
	public void setHits(Long hits) {
		this.hits = hits;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getRegitster_Date() {
		return regitster_Date;
	}
	public void setRegitster_Date(String regitster_Date) {
		this.regitster_Date = regitster_Date;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "FreePostVO [post_No=" + post_No + ", id=" + id + ", title=" + title + ", content=" + content + ", hits="
				+ hits + ", nickname=" + nickname + ", regitster_Date=" + regitster_Date + ", category=" + category
				+ "]";
	}
}