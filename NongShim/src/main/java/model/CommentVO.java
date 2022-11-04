package model;

public class CommentVO {
	
	private String id;
	private long postno;
	private String writtenDate;
	private String content;
	private String category;
	
	public CommentVO() {}

	public CommentVO(String id, long postno, String writtenDate, String content, String category) {
		super();
		this.id = id;
		this.postno = postno;
		this.writtenDate = writtenDate;
		this.content = content;
		this.category = category;
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
	};
	
	
	

}
