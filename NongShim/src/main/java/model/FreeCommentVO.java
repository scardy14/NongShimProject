package model;

public class FreeCommentVO {
	private long postno;
	private String id;
	private String nickName;
	private String writtenDate;
	private String content;

	public FreeCommentVO() {
	}

	public FreeCommentVO(long postno, String id, String nickName, String writtenDate, String content) {
		super();
		this.postno = postno;
		this.id = id;
		this.nickName = nickName;
		this.writtenDate = writtenDate;
		this.content = content;
	}

	public long getPostno() {
		return postno;
	}

	public void setPostno(long postno) {
		this.postno = postno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getWrittenDate() {
		return writtenDate;
	}

	public void setWrittenDate(String writtenDate) {
		this.writtenDate = writtenDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
