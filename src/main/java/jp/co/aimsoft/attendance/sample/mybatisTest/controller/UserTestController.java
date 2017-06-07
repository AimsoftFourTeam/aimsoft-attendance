package jp.co.aimsoft.attendance.sample.mybatisTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.aimsoft.attendance.sample.mybatisTest.dao.domain.UserDto;
import jp.co.aimsoft.attendance.sample.mybatisTest.form.UserForm;
import jp.co.aimsoft.attendance.sample.mybatisTest.helper.UserHelper;
import jp.co.aimsoft.attendance.sample.mybatisTest.service.UserServiceImpl;

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

	/** コンストラクタ. */
	public UserTestController() {

	}

	/**
	 * 初期表示.
	 *
	 * @return response
	 */
	@RequestMapping(value = "/mybatis/display", method = RequestMethod.GET)
	public String mybatisTestFirstDisplay() {

		return "sample/demo1";
	}

	/**
	 * ユーザー情報を1件登録
	 *
	 * @param model
	 *            ユーザー情報
	 * @return response
	 */
	@RequestMapping(value = "/mybatis/add", method = RequestMethod.POST)
	public String mybatisTestAdd(@ModelAttribute UserForm form) {

		UserDto userDto = helper.createUserDto(form);

		userService.addUser(userDto);
		return "sample/mybatisTestAddResult";
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

		List<UserDto> userDtoList = userService.findByUserId();
		viewable.addObject("userModelList", userDtoList);
		viewable.setViewName("sample/mybatisTestGetAll");
		return viewable;
	}

}
