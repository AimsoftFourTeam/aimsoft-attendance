package jp.co.aimsoft.attendance.sample.mybatisTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.aimsoft.attendance.sample.mybatisTest.form.LoginForm;

@Controller
public class LoginController {

	@RequestMapping(value = "/testToday", method = RequestMethod.GET)
	public ModelAndView LoginMenu() {
		ModelAndView LoginMenu = new ModelAndView();
		LoginMenu.setViewName("sample/Login");
		LoginForm loginInfo = new LoginForm();
		loginInfo.setId("19940323");
		loginInfo.setName("k.takahashi");
		LoginMenu.addObject("model", loginInfo);
		return LoginMenu;
	}
}
