package com.CRUDp.web.admin.dto;

import java.util.Date;

public class BoardDto {
	private int id;
	private String title;
	private String content;
	private Date regDate;
	private int hit;
	private String files;
	private String writerId;

	public BoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardDto(int id, String title, String content, Date regDate, int hit, String files, String writerId) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.hit = hit;
		this.files = files;
		this.writerId = writerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	@Override
	public String toString() {
		return "BoardDto [id=" + id + ", title=" + title + ", content=" + content + ", regDate=" + regDate + ", hit="
				+ hit + ", files=" + files + ", writerId=" + writerId + "]";
	}

}
