package jp.co.aimsoft.attendance.sample.mybatisTest.dao.domain;

/**
 * ユーザーDTO.
 */
public class UserDto {

	/** ユーザーID. */
	private String userId;

	/** ユーザー名. */
	private String userName;

	/** 所属. */
	private String department;

	/** 役職. */
	private String position;

	/** パスワード. */
	private String password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}