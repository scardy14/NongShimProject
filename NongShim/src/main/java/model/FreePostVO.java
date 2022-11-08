package model;

public class FreePostVO { 
	private Long post_No;
	private String id;
	private String title;
	private String content;
	private	Long hits;
	private String nickname;
	private String register_Date;
	
	public FreePostVO() {
		super();
		
	}
	// 게시글 상세보기
	public FreePostVO(Long post_No, String id, String title, String content, Long hits, String nickname,
			String regitster_Date) {
		super();
		this.post_No = post_No;
		this.id = id;
		this.title = title;
		this.content = content;
		this.hits = hits;
		this.nickname = nickname;
		this.register_Date = regitster_Date;
	}
	//게시글 리스트
	public FreePostVO(Long post_No, String title, Long hits, String nickname, String regitster_Date) {
		super();
		this.post_No = post_No;
		this.title = title;
		this.hits = hits;
		this.nickname = nickname;
		this.register_Date = regitster_Date;
	}
	// 게시글 작성
	public FreePostVO(String id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
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
	public String getRegister_Date() {
		return register_Date;
	}
	public void setRegister_Date(String register_Date) {
		this.register_Date = register_Date;
	}
	@Override
	public String toString() {
		return "FreePostVO [post_No=" + post_No + ", id=" + id + ", title=" + title + ", content=" + content + ", hits="
				+ hits + ", nickname=" + nickname + ", register_Date=" + register_Date + "]";
	}
}