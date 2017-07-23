package jp.co.aimsoft.attendance.sample.mybatisTest.form;

/**
 * ログイン画面用フォームクラス.
 */
public class LoginForm {

	/** ユーザーID. */
	private String userId;

	/** パスワード. */
	private String password;

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

	/**
	 * デフォルトコンストラクタ.
	 */
	public LoginForm() {

	}
}