package jp.co.aimsoft.attendance.sample.mybatisTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.aimsoft.attendance.sample.mybatisTest.form.TodayForm;

@Controller
public class TodayController {

	@RequestMapping(value = "/testToday", method = RequestMethod.GET)
	public ModelAndView MAVtoday() {
		ModelAndView a = new ModelAndView();
		a.setViewName("sample/taka_test");
		TodayForm b = new TodayForm();
		b.setToday("2017年6月22日");
		a.addObject("model", b);
		return a;
	}
}
