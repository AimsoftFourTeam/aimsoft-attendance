package jp.co.aimsoft.attendance.sample.mybatisTest.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.Map;

import org.springframework.stereotype.Service;

import jp.co.aimsoft.attendance.sample.common.util.SecurityUtil;
import jp.co.aimsoft.attendance.sample.mybatisTest.model.LoginModel;

/**
 * ログイン画面業務ロジック.
 */
@Service
public class LoginServiceImpl implements LoginService {

	@Override
	public LoginModel allowLogin(LoginModel model) {

		LocalDateTime beforeTime = LocalDateTime.now();
		// パスワードとソルトを取得。ともにDBに詰めるがいったんこのまま結果を返す。
		Map<String, String> result = SecurityUtil.getHashedPasswordAndSalt(model.getPassword());
		LocalDateTime afterTime = LocalDateTime.now();
		this.setResultToLoginModel(model, result, beforeTime, afterTime);

		return model;
	}

	/**
	 * LoginModelに処理結果を設定します。
	 * 
	 * @param model
	 *            ログインモデル
	 * @param map
	 *            ハッシュ化されたパスワードとソルトを持つmap
	 * @param before
	 *            処理前の時間
	 * @param after
	 *            処理後の時間
	 */
	private void setResultToLoginModel(LoginModel model, Map<String, String> map, LocalDateTime before,
			LocalDateTime after) {

		model.setPassword(map.get("password"));
		model.setSalt(map.get("salt"));

		// 処理時間測定
		double beforeMs = before.getLong(ChronoField.MILLI_OF_SECOND);
		double afterMs = after.getLong(ChronoField.MILLI_OF_SECOND);
		double processSec;
		if (afterMs > beforeMs) {
			processSec = (afterMs - beforeMs) / 1000;
		} else {
			processSec = (afterMs + 1000 - beforeMs) / 1000;
		}

		// 秒で表示したい
		model.setProcessTime(processSec);
	}

}