package jp.co.aimsoft.attendance.sample.mybatisTest.helper;

import org.springframework.stereotype.Component;

import jp.co.aimsoft.attendance.sample.mybatisTest.dao.domain.UserDto;
import jp.co.aimsoft.attendance.sample.mybatisTest.form.UserForm;

/**
 * UserTestControllerのヘルパークラス. FIXME このクラスをヘルパーとして使用してよいか。他に適切なコンポーネントがないか。
 */
@Component
public class UserHelper {

	/**
	 * コンストラクタ.
	 */
	public UserHelper() {

	}

	public UserDto createUserDto(UserForm form) {

		UserDto dto = new UserDto();
		dto.setUserId(form.getUserId());
		dto.setUserName(form.getUserName());
		dto.setUserPassword(form.getUserPassword());

		return dto;
	}
}