package jp.co.aimsoft.attendance.sample.mybatisTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.aimsoft.attendance.sample.mybatisTest.form.LoginForm;
import jp.co.aimsoft.attendance.sample.mybatisTest.helper.NameListHelper;

@Controller
public class LoginController {

	// インスタンス化しなくてもSpringBootだとAutowiredアノテーションで他クラスを紐づけ！
	@Autowired
	private NameListHelper helper;

	// 最初のアクセス"/Login"というURLをGETし、ログイン画面を表示
	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public ModelAndView FirstDisplay() {
		ModelAndView modelAndView = new ModelAndView();
		// モデル＆ビューに次ぎの画面のURLを渡す
		modelAndView.setViewName("sample/Login");
		return modelAndView;
	}

	// "/LoginCheck"というURLにフォーム情報や次の画面のURLを渡す
	@RequestMapping(value = "/LoginCheck", method = RequestMethod.POST)
	// ModelAndView アノテーションでフォームクラスをインスタンス化
	public ModelAndView LoginMenu(@ModelAttribute LoginForm form) {
		ModelAndView LoginMenu = new ModelAndView();
		LoginMenu.setViewName("sample/EgitHome");
		LoginMenu.addObject("model", form);
		LoginMenu.addObject("syainitems", helper.getListItems());
		return LoginMenu;
	}

}
