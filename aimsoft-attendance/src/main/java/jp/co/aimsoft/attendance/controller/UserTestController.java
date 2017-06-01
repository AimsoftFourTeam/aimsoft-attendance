package jp.co.aimsoft.attendance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * SpringBoot-MyBatis-Postgres.
 */
@Controller
public class UserTestController {

	/** コンストラクタ. */
	public UserTestController() {

	}

	/**
	 * 初期表示.
	 * 
	 * @return response
	 */
	@RequestMapping("/test")
	public ModelAndView mybatisTestFirstDisplay() {

		ModelAndView viewable = new ModelAndView();
		viewable.setViewName("mybatisTest");

		return viewable;
	}

}
