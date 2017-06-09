package jp.co.aimsoft.attendance.sample.mybatisTest.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import jp.co.aimsoft.attendance.sample.mybatisTest.form.UserForm;

@Component
public class UserValidator implements Validator {

	/**
	 * 対象のオブジェクトがこのクラスが対象とするクラスかをチェックする。
	 */
	@Override
	public boolean supports(Class<?> clazz) {

		return UserForm.class.isAssignableFrom(clazz);
	}

	/**
	 * Validatorメソッド
	 */
	@Override
	public void validate(Object target, Errors errors) {

		UserForm userForm = (UserForm) target;

		// ユーザーIDが未入力の場合
		if (StringUtils.isEmpty(userForm.getUserId())) {
			/*
			 * rejectValue({プロパティ名}, {エラーコード}, {メッセージ引数配列},{デフォルトメッセージ}])
			 */
			errors.rejectValue("userId", "error.com.required", new String[] { "ユーザID" }, "エラーメッセージが見つかりません。");
		}
	}

}
