package com.CRUDp.web.admin.dto;

import java.sql.Date;

public class UserDto {
	private String email;
	private String password;
	private String nickname;
	private Date birth;
	private String phoneNumber;

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDto(String email, String password, String nickname, Date birth, String phoneNumber) {
		super();
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.birth = birth;
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "UserDto [email=" + email + ", password=" + password + ", nickname=" + nickname + ", Birth=" + birth
				+ ", phoneNumber=" + phoneNumber + "]";
	}

}
