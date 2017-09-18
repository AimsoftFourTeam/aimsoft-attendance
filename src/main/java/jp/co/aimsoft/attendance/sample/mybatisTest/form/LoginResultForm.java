package jp.co.aimsoft.attendance.sample.mybatisTest.form;

public class LoginResultForm {

	/** ユーザーID. */
	private String userId;

	/** パスワード. */
	private String password;

	/** 処理時間. */
	private double processTime;

	public double getProcessTime() {
		return processTime;
	}

	public void setProcessTime(double processTime) {
		this.processTime = processTime;
	}

	/** デフォルトコンストラクタ. */
	public LoginResultForm() {

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

}
