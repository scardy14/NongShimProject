package model;

public class CommentVO {
	
	private String id;
	private long postno;
	private String writtenDate;
	private String content;
	private String category;
	private long comment_No;
	
	public CommentVO() {}

	public CommentVO(String id, long postno, String writtenDate, String content, String category) {
		super();
		this.id = id;
		this.postno = postno;
		this.writtenDate = writtenDate;
		this.content = content;
		this.category = category;
	}
	

	public CommentVO(String id, long postno, String writtenDate, String content, String category, long comment_No) {
		super();
		this.id = id;
		this.postno = postno;
		this.writtenDate = writtenDate;
		this.content = content;
		this.category = category;
		this.comment_No = comment_No;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getPostno() {
		return postno;
	}

	public void setPostno(long postno) {
		this.postno = postno;
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

	public void setContent(String contetn) {
		this.content = contetn;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getComment_No() {
		return comment_No;
	}

	public void setComment_No(long comment_No) {
		this.comment_No = comment_No;
	};
	
	
	

}
