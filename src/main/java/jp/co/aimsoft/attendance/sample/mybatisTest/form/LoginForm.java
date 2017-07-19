package jp.co.aimsoft.attendance.sample.mybatisTest.form;

public class LoginForm {
	private long id;
	private String name;

	public long getUserId() {
		return id;
	}

	public void setUserId(long userId) {
		this.id = userId;
	}

	public String getUserName() {
		return name;
	}

	public void setUserName(String userName) {
		this.name = userName;
	}
}
