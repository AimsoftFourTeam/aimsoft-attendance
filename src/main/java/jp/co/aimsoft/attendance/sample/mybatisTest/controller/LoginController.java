package jp.co.aimsoft.attendance.sample.mybatisTest.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.aimsoft.attendance.sample.mybatisTest.form.LoginForm;

@Controller
public class LoginController {

	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public ModelAndView FirstDisplay() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("sample/Login");
		return modelAndView;
	}

	@RequestMapping(value = "/LoginCheck", method = RequestMethod.POST)
	public ModelAndView LoginMenu(@ModelAttribute LoginForm form) {
		ModelAndView LoginMenu = new ModelAndView();
		LoginMenu.setViewName("sample/EgitHome");
		LoginMenu.addObject("model", form);
		LoginMenu.addObject("syainitems", getListItems());
		return LoginMenu;
	}

	private Map<Integer, ArrayList<String>> getListItems() {
		Map<Integer, ArrayList<String>> ListItems = new LinkedHashMap<Integer, ArrayList<String>>();

		ArrayList<String> zero = new ArrayList<String>();
		zero.add("例）エイム　太郎");
		zero.add("例）1989年4月1日");
		zero.add("例）営業部");
		zero.add("例）本社");
		ListItems.put(0, zero);

		ListItems.put(1, new ArrayList<String>() {
			{
				add("木村　拓哉");
			}
		});
		ListItems.put(2, new ArrayList<String>() {
			{
				add("中居　正広");
			}
		});
		ListItems.put(3, new ArrayList<String>() {
			{
				add("稲垣　吾郎");
			}
		});
		ListItems.put(4, new ArrayList<String>() {
			{
				add("草彅　剛");
			}
		});
		ListItems.put(5, new ArrayList<String>() {
			{
				add("香取　慎吾");
			}
		});
		return ListItems;
	}

}
