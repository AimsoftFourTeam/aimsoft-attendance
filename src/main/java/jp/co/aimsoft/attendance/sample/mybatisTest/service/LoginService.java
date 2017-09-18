package jp.co.aimsoft.attendance.sample.mybatisTest.service;

import jp.co.aimsoft.attendance.sample.mybatisTest.model.LoginModel;

public interface LoginService {

	LoginModel authenticate(LoginModel model);
}