package com.vti.ProductManagement.backend.entity;

import java.sql.Date;

public class Account {
	private int accountId;
	private String email;
	private String username;
	private String fullname;
	private String avatarImage;
	private String mobile;
	private String address;
	private Date createDate;
	private String password;
	private int status = 0;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int accountId, String email, String username, String fullname, String avatarImage, String mobile,
			String address, Date createDate, String password, int status) {
		super();
		this.accountId = accountId;
		this.email = email;
		this.username = username;
		this.fullname = fullname;
		this.avatarImage = avatarImage;
		this.mobile = mobile;
		this.address = address;
		this.createDate = createDate;
		this.password = password;
		this.status = status;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAvatarImage() {
		return avatarImage;
	}

	public void setAvatarImage(String avatarImage) {
		this.avatarImage = avatarImage;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", email=" + email + ", username=" + username + ", fullname="
				+ fullname + ", avatarImage=" + avatarImage + ", mobile=" + mobile + ", address=" + address
				+ ", createDate=" + createDate + ", password=" + password + ", status=" + status + "]";
	}

}
