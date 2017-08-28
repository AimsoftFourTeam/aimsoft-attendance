package jp.co.aimsoft.attendance.sample.mybatisTest.helper;

import org.springframework.stereotype.Component;

import jp.co.aimsoft.attendance.sample.mybatisTest.form.UserForm;
import jp.co.aimsoft.attendance.sample.mybatisTest.model.UserModel;

/**
 * UserTestControllerのヘルパークラス.
 */
@Component
public class UserHelper {

	/**
	 * コンストラクタ.
	 */
	public UserHelper() {

	}

	public UserModel createUserDto(UserForm form) {

		UserModel model = new UserModel();
		model.setUserId(form.getUserId());
		model.setUserName(form.getUserName());
		model.setDepartment(form.getDepartment());
		model.setPosition(form.getPosition());
		model.setPassword(form.getPassword());

		return model;
	}
}