package jp.co.aimsoft.attendance.sample.mybatisTest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.aimsoft.attendance.sample.mybatisTest.dao.domain.UserDto;
import jp.co.aimsoft.attendance.sample.mybatisTest.form.UserForm;
import jp.co.aimsoft.attendance.sample.mybatisTest.helper.UserHelper;
import jp.co.aimsoft.attendance.sample.mybatisTest.service.UserServiceImpl;
import jp.co.aimsoft.attendance.sample.mybatisTest.validator.UserValidator;

/**
 * SpringBoot-MyBatis-Postgres.
 */
@Controller
public class UserTestController {

	/** ユーザーロジック. */
	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private UserHelper helper;

	@Autowired
	private UserValidator userValidator;

	/** コンストラクタ. */
	public UserTestController() {

	}

	@InitBinder("userForm")
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(userValidator);
	}

	/**
	 * 初期表示.
	 *
	 * @return response
	 */
	@RequestMapping(value = "/mybatis/display", method = RequestMethod.GET)
	public ModelAndView mybatisTestFirstDisplay() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", null);
		modelAndView.setViewName("sample/demo1");
		return modelAndView;
	}

	/**
	 * ユーザー情報を1件登録
	 *
	 * @param model
	 *            ユーザー情報
	 * @return response
	 */
	@RequestMapping(value = "/mybatis/add", method = RequestMethod.POST)
	public ModelAndView mybatisTestAdd(@Valid @ModelAttribute UserForm form, BindingResult result) {

		ModelAndView modelAndView = new ModelAndView();

		// Validation Errorがある場合
		if (result.hasErrors()) {

			String message = "Please fill UserId.";
			modelAndView.addObject("message", message);
			modelAndView.setViewName("sample/demo1");
			return modelAndView;
		}

		// TODO DB環境が整ったのち復活させる
		UserDto userDto = helper.createUserDto(form);

		userService.addUser(userDto);
		modelAndView.setViewName("sample/mybatisTestAddResult");
		return modelAndView;
	}

	/**
	 * 全件取得し画面に表示する。
	 *
	 * @param viewable
	 *            ModelAndView
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/mybatis/select", method = RequestMethod.GET)
	public ModelAndView mybatisTestGetAll(ModelAndView viewable) {
		// TODO DB環境が整ったのち復活させる
		List<UserDto> userDtoList = userService.findByUserId();
		viewable.addObject("userModelList", userDtoList);
		viewable.setViewName("sample/mybatisTestGetAll");
		return viewable;
	}

}
