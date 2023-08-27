package com.CRUDp.web.admin.dto;

import java.sql.Date;

public class CmtDto {
	private int id;
	private String content;
	private Date regDate;
	private String writerId;
	private int boardId;

	public CmtDto() {
		// TODO Auto-generated constructor stub
	}

	public CmtDto(int id, String content, Date regDate, String writerId, int boardId) {
		this.id = id;
		this.content = content;
		this.regDate = regDate;
		this.writerId = writerId;
		this.boardId = boardId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	@Override
	public String toString() {
		return "CommentDto [id=" + id + ", content=" + content + ", regDate=" + regDate + ", writerId=" + writerId
				+ ", boardId=" + boardId + "]";
	}

}
