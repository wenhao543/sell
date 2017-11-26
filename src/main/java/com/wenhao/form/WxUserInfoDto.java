package com.wenhao.form;

public class WxUserInfoDto {
	
	private String userName;
	private String userId;
	private String userAge;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserAge() {
		return userAge;
	}
	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}
	@Override
	public String toString() {
		return "WxUserInfoDto [userName=" + userName + ", userId=" + userId + ", userAge=" + userAge + "]";
	}
	

}
