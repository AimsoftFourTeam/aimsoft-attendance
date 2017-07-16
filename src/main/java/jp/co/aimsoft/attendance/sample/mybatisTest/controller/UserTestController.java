package jp.co.aimsoft.attendance.sample.mybatisTest.controller;

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

import jp.co.aimsoft.attendance.sample.mybatisTest.form.UserForm;
import jp.co.aimsoft.attendance.sample.mybatisTest.helper.UserHelper;
import jp.co.aimsoft.attendance.sample.mybatisTest.service.UserService;
import jp.co.aimsoft.attendance.sample.mybatisTest.validator.UserValidator;

/**
 * SpringBoot-MyBatis-Postgres.
 */
@Controller
@RequestMapping("iwai")
public class UserTestController {

	/** ユーザーロジック. */
	@Autowired
	private UserService userService;

	@Autowired
	private UserHelper helper;

	@Autowired
	private UserValidator userValidator;

	/** コンストラクタ. */
	public UserTestController() {

	}

	/**
	 * formにValidatorをバインドする。<br />
	 * InitBinder内の指定値は、各Controllerメソッドが画面入力値を受け取る<br />
	 * formクラスの変数名とする必要がある。
	 * 
	 * @param binder
	 *            binder
	 */
	@InitBinder("form")
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(userValidator);
	}

	/**
	 * 初期表示.<br />
	 *
	 * @return response response
	 */
	@RequestMapping(value = "/mybatis/display", method = RequestMethod.GET)
	public ModelAndView mybatisTestFirstDisplay() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("form", new UserForm());
		modelAndView.setViewName("sample/demo1");
		return modelAndView;
	}

	/**
	 * ユーザー情報を1件登録<br />
	 * ModelAttributeの引数に、Validを付与したformの変数名を指定する。<br />
	 * また、initBinderにこの変数名を指定することで、<br />
	 * 画面に指定したform名のオブジェクト名にてエラー情報を含むバインドされたformの値が返却される。<br />
	 * 引数の並び順はFrameworkのアーキテクト上、固定なため注意が必要<br />
	 *
	 * @param model
	 *            ユーザー情報
	 * @return response
	 */
	@RequestMapping(value = "/mybatis/add", method = RequestMethod.POST)
	public ModelAndView mybatisTestAdd(@ModelAttribute("form") @Valid UserForm form, BindingResult result) {

		ModelAndView modelAndView = new ModelAndView();

		// Validation Errorがある場合
		if (result.hasErrors()) {

			modelAndView.addObject("form", form);
			modelAndView.setViewName("sample/demo1");
			return modelAndView;
		}

		// TODO DB環境が整ったのち復活させる
		// UserDto userDto = helper.createUserDto(form);
		//
		// userService.addUser(userDto);
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
		// List<UserDto> userDtoList = userService.findAll();
		// viewable.addObject("userModelList", userDtoList);
		viewable.setViewName("sample/mybatisTestGetAll");
		return viewable;
	}

}
