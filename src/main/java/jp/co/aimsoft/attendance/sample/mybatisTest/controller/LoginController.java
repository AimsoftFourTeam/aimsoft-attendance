package jp.co.aimsoft.attendance.sample.mybatisTest.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.aimsoft.attendance.sample.mybatisTest.form.LoginForm;
import jp.co.aimsoft.attendance.sample.mybatisTest.form.LoginResultForm;
import jp.co.aimsoft.attendance.sample.mybatisTest.model.LoginModel;
import jp.co.aimsoft.attendance.sample.mybatisTest.service.LoginService;

@Controller
@RequestMapping("iwai/login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	/**
	 * ログイン画面を表示します。
	 *
	 * @return
	 */
	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public String show() {
		return "sample/login";
	}

	/**
	 * ログインし、次画面へ遷移します。
	 *
	 * @return Response
	 */
	@RequestMapping(value = "/to-next", method = RequestMethod.POST)
	public ModelAndView toNext(@ModelAttribute("form") LoginForm form) {

		LoginModel model = new LoginModel();
		BeanUtils.copyProperties(form, model);
		LoginModel resultModel = loginService.allowLogin(model);
		LoginResultForm nextForm = new LoginResultForm();
		BeanUtils.copyProperties(resultModel, nextForm);

		ModelAndView view = new ModelAndView();
		view.addObject("form", nextForm);
		view.setViewName("sample/loginResult");

		return view;
	}

}