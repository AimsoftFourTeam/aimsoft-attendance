package jp.co.aimsoft.attendance.sample.mybatisTest.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.aimsoft.attendance.sample.common.util.SecurityUtil;
import jp.co.aimsoft.attendance.sample.mybatisTest.dao.UserMapper;
import jp.co.aimsoft.attendance.sample.mybatisTest.dao.domain.UserDto;
import jp.co.aimsoft.attendance.sample.mybatisTest.model.LoginModel;

/**
 * SecurityUtil性能調査.
 */
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserMapper mapper;

	/**
	 * 認証処理を行い、処理結果時間および認証結果を返却します。
	 * 
	 * @param model
	 *            LoginModel
	 * 
	 * @return LoginModel
	 */
	@Override
	public LoginModel authenticate(LoginModel model) {

		LocalDateTime beforeTime = LocalDateTime.now();
		UserDto dto = mapper.findOne(model.getUserId());

		boolean result = false;
		if (dto != null) {
			result = SecurityUtil.authenticate(model.getUserId(), model.getPassword(), dto.getPassword());
		}
		LocalDateTime afterTime = LocalDateTime.now();
		this.setResultToLoginModel(model, beforeTime, afterTime, result);

		return model;
	}

	/**
	 * LoginModelに処理結果を設定します。
	 * 
	 * @param model
	 *            loginModel
	 * @param before
	 *            処理前の時間
	 * @param after
	 *            処理後の時間
	 * 
	 * @param result
	 *            認証結果
	 */
	private void setResultToLoginModel(LoginModel model, LocalDateTime before, LocalDateTime after, boolean result) {

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

		model.setOk(result);

	}

}