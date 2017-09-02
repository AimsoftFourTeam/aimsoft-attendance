package jp.co.aimsoft.attendance.sample.mybatisTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * SpringBoot-MyBatis-Postgres.
 */
@Controller
@RequestMapping("iwai")
public class AjaxTestController {

	/** コンストラクタ. */
	public AjaxTestController() {

	}
	
	/**
	 * 初期表示.
	 * 
	 * @return　response
	 */
	@RequestMapping(value = "/ajaxTest/display", method = RequestMethod.POST)
	public ModelAndView display(){
		
		ModelAndView mav = new ModelAndView("sample/ajaxTest");
		return mav;
	}


}