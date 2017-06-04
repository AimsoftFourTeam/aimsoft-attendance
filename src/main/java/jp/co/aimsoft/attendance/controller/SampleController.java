package jp.co.aimsoft.attendance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class SampleController {

	/** コンストラクタ. */
	public SampleController() {

	}
	
	/**
	 * 初期表示.
	 * 
	 * @return response
	 */
	@RequestMapping("/tapsuggestSample")
	public ModelAndView tapsuggestSample() {

		ModelAndView viewable = new ModelAndView();
		viewable.setViewName("/sample/tapsuggest");

		return viewable;
	}
}
