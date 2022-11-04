package model;

public class AnnouncePostVO {
	private Long post_No;
	private String id;
	private String title;
	private String content;
	private Long hits;
	private String nickname;
	private String register_Date;
	
	
	
	//게시물리스트 보여줄 때 필요한 생성자
	public AnnouncePostVO(Long post_No, String title, Long hits, String nickname, String register_Date) {
		super();
		this.post_No = post_No;
		this.title = title;
		this.hits = hits;
		this.nickname = nickname;
		this.register_Date = register_Date;
	}

	
	//게시물 상세보기에서 필요한 생성자
	public AnnouncePostVO(Long post_No, String id, String title, String content, Long hits, String nickname,
			String register_Date) {
		super();
		this.post_No = post_No;
		this.id = id;
		this.title = title;
		this.content = content;
		this.hits = hits;
		this.nickname = nickname;
		this.register_Date = register_Date;
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
		return "AnnouncePostVO [post_No=" + post_No + ", id=" + id + ", title=" + title + ", content=" + content
				+ ", hits=" + hits + ", nickname=" + nickname + ", register_Date=" + register_Date + "]";
	}
	
	
}
