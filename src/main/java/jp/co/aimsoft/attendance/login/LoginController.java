package jp.co.aimsoft.attendance.login;

import org.springframework.stereotype.Controller;
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

	@RequestMapping(value = "/Menue", method = RequestMethod.POST)
	public String LoginMenu() {
		return "999";
	}
}
