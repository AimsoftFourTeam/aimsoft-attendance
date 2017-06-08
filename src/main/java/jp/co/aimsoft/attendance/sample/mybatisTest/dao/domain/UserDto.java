package jp.co.aimsoft.attendance.sample.mybatisTest.dao.domain;

/**
 * ユーザーDTO.
 */
public class UserDto {

	/** ユーザーID. */
	private String userId;

	/** ユーザー名. */
	private String userName;

	/** ユーザーパスワード. */
	private String userPassword;

	/** 保有有給休暇日数. */
	private String numberOdaysPaidVacation;

	/** コンストラクタ. */
	public UserDto() {

	}

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

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getNumberOdaysPaidVacation() {
		return numberOdaysPaidVacation;
	}

	public void setNumberOdaysPaidVacation(String numberOdaysPaidVacation) {
		this.numberOdaysPaidVacation = numberOdaysPaidVacation;
	}

	// public class SUser {
	//
	// private String sUserId;
	//
	// private String password;
	//
	// private String name;
	//
	// private String eMail;
	//
	// private String introduceMyself;
	//
	// private String regUserId;
	//
	// private Timestamp regTimestamp;
	//
	// private String updUserId;
	//
	// /**
	// * ■MyBatisレファレンス Type Handler Java Types JDBC Types
	// SqlTimestampTypeHandler
	// * java.sql.Timestamp TIMESTAMP DateTypeHandler java.util.Date TIMESTAMP
	// * 一応Stringでも取れるけど、比較のときに・・・
	// */
	// private Timestamp updTimestamp;
	//
	// public String getsUserId() {
	// return sUserId;
	// }
	//
	// public void setsUserId(String sUserId) {
	// this.sUserId = sUserId;
	// }
	//
	// public String getPassword() {
	// return password;
	// }
	//
	// public void setPassword(String password) {
	// this.password = password;
	// }
	//
	// public String getName() {
	// return name;
	// }
	//
	// public void setName(String name) {
	// this.name = name;
	// }
	//
	// public String geteMail() {
	// return eMail;
	// }
	//
	// public void seteMail(String eMail) {
	// this.eMail = eMail;
	// }
	//
	// public String getIntroduceMyself() {
	// return introduceMyself;
	// }
	//
	// public void setIntroduceMyself(String introduceMyself) {
	// this.introduceMyself = introduceMyself;
	// }
	//
	// public String getRegUserId() {
	// return regUserId;
	// }
	//
	// public void setRegUserId(String regUserId) {
	// this.regUserId = regUserId;
	// }
	//
	// public Timestamp getRegTimestamp() {
	// return regTimestamp;
	// }
	//
	// public void setRegTimestamp(Timestamp regTimestamp) {
	// this.regTimestamp = regTimestamp;
	// }
	//
	// public String getUpdUserId() {
	// return updUserId;
	// }
	//
	// public void setUpdUserId(String updUserId) {
	// this.updUserId = updUserId;
	// }
	//
	// public Timestamp getUpdTimestamp() {
	// return updTimestamp;
	// }
	//
	// public void setUpdTimestamp(Timestamp updTimestamp) {
	// this.updTimestamp = updTimestamp;
	// }
	//
	// public SUser() {
	//
	// }
	//
	// /**
	// * コンストラクタ すべての値を格納する際に使用する。
	// *
	// * @param sUserId
	// * ユーザID
	// * @param password
	// * パスワード
	// * @param name
	// * 名前
	// * @param eMail
	// * e-mail
	// * @param introduceMyself
	// * 自己紹介
	// */
	// public SUser(String sUserId, String password, String name, String eMail,
	// String introduceMyself) {
	//
	// this.sUserId = sUserId;
	// this.password = password;
	// this.name = name;
	// this.eMail = eMail;
	// this.introduceMyself = introduceMyself;
	// }
}
