package jp.co.aimsoft.attendance.sample.mybatisTest.model;

public class LoginModel {

	/** ユーザーID. */
	private String userId;

	/** パスワード. */
	private String password;

	/** 処理時間. */
	private double processTime;

	/** ソルト. */
	private String salt;

	/** デフォルトコンストラクタ. */
	public LoginModel() {

	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getProcessTime() {
		return processTime;
	}

	public void setProcessTime(double processTime) {
		this.processTime = processTime;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

}
