package jp.co.aimsoft.attendance.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public ModelAndView FirstDisplay() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("sample/Login");
		return modelAndView;
	}

	@RequestMapping(value = "/Menu", method = RequestMethod.POST)
	public ModelAndView LoginMenu(@ModelAttribute LoginForm form) {
		ModelAndView LoginMenu = new ModelAndView();
		LoginMenu.setViewName("sample/Menu");
		LoginMenu.addObject("model", form);
		return LoginMenu;
	}
}
