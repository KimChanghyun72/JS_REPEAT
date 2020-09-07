package com.dev.model;

public class MemberVO {
	private String id;
	private String password;
	private String job;
	private String reason;
	private String gender;
	private String mailsend;
	private String hobby;
	private String regdate;
	
	
	
	public MemberVO(String id, String password, String job, String reason, String gender, String mailsend, String hobby,
			String regdate) {
		super();
		this.id = id;
		this.password = password;
		this.job = job;
		this.reason = reason;
		this.gender = gender;
		this.mailsend = mailsend;
		this.hobby = hobby;
		this.regdate = regdate;
	}

	public MemberVO() {
		super();
	}
	
	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMailsend() {
		return mailsend;
	}
	public void setMailsend(String mailsend) {
		this.mailsend = mailsend;
	}
	
	
	
}
