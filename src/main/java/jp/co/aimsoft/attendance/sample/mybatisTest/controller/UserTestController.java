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

import jp.co.aimsoft.attendance.sample.common.util.SecurityUtil;
import jp.co.aimsoft.attendance.sample.mybatisTest.dao.domain.UserDto;
import jp.co.aimsoft.attendance.sample.mybatisTest.form.UserForm;
import jp.co.aimsoft.attendance.sample.mybatisTest.helper.UserHelper;
import jp.co.aimsoft.attendance.sample.mybatisTest.model.UserModel;
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

		userService.getSampleStub();

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("form", new UserForm());
		modelAndView.setViewName("sample/demo");

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
			modelAndView.setViewName("sample/demo");
			return modelAndView;
		}

		UserModel model = helper.createUserDto(form);

		userService.addUser(model);
		modelAndView.setViewName("sample/demoResult");
		return modelAndView;
	}

	/**
	 * 全件取得し画面に表示する。
	 *
	 * @param viewable
	 *            ModelAndView
	 * @return Response
	 */
	@RequestMapping(value = "/mybatis/select", method = RequestMethod.POST)
	public ModelAndView mybatisTestGetAll() {

		ModelAndView viewable = new ModelAndView();
		List<UserDto> userDtoList = userService.findAll();
		viewable.addObject("userModelList", userDtoList);
		viewable.setViewName("sample/demoList");
		return viewable;
	}

	/**
	 * ユーザーIDを元にUserMasterを１件更新します。
	 * 
	 * @param form
	 *            form
	 * @param result
	 *            バリデーション結果
	 * @return Response
	 */
	@RequestMapping(value = "/mybatis/update", method = RequestMethod.POST)
	public ModelAndView mybatisTestUpdateOne(@ModelAttribute("form") @Valid UserForm form, BindingResult result) {

		ModelAndView modelAndView = new ModelAndView();

		// Validation Errorがある場合
		if (result.hasErrors()) {

			modelAndView.addObject("form", form);
			modelAndView.setViewName("sample/demo");
			return modelAndView;
		}

		UserModel model = helper.createUserDto(form);

		userService.updateOne(model);
		modelAndView.setViewName("sample/demoResult");
		return modelAndView;
	}

	/**
	 * UserMaster全件削除します。
	 * 
	 * @return Response
	 */
	@RequestMapping(value = "/mybatis/delete", method = RequestMethod.POST)
	public ModelAndView mybatisTestDeleteAll() {

		userService.deleteAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("sample/demoResult");
		return modelAndView;
	}

	/**
	 * UserMaster全件削除します。
	 * 
	 * @return Response
	 */
	@RequestMapping(value = "/mybatis/authenticate", method = RequestMethod.POST)
	public ModelAndView authenticate(@ModelAttribute UserForm form) {

		// DB登録済みパスワードを取得
		String registeredPassword = userService.getPassword(form.getUserId());

		boolean authenticateResult = SecurityUtil.authenticate(form.getUserId(), form.getPassword(),
				registeredPassword);

		ModelAndView modelAndView = new ModelAndView();
		if (authenticateResult) {
			modelAndView.setViewName("sample/demoResult");
		} else {
			modelAndView.setViewName("index");
		}
		return modelAndView;
	}

}