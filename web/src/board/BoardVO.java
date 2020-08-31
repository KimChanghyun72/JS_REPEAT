package board;

public class BoardVO {
	private Integer no;
	private String poster;
	private String subject;
	private String contents;
	private String lastpost;
	private Integer views;
	private String filename;
	
	public BoardVO() {
		super();
	}
	public BoardVO(String poster, String subject, String contents, String filename) {
		super();
		this.poster = poster;
		this.subject = subject;
		this.contents = contents;
		this.filename = filename;
	}
	
	@Override
	public String toString() {
		return "BoardVO [poster=" + poster + ", subject=" + subject + ", contents=" + contents + ", filename="
				+ filename + "]";
	}
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getLastpost() {
		return lastpost;
	}
	public void setLastpost(String lastpost) {
		this.lastpost = lastpost;
	}
	public Integer getViews() {
		return views;
	}
	public void setViews(Integer views) {
		this.views = views;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
}
