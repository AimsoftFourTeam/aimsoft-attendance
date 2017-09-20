package jp.co.aimsoft.attendance.sample.mybatisTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.aimsoft.attendance.sample.mybatisTest.form.SessionScopedBeanSampleForm;
import jp.co.aimsoft.attendance.sample.mybatisTest.model.SessionBeanSample;

@Controller
@RequestMapping("iwai")
public class SessionScopedBeanSampleController {

	@Autowired
	private SessionBeanSample bean;

	/**
	 * 最初の画面を表示します。
	 *
	 * @return response
	 */
	@RequestMapping(value = "/first/show", method = RequestMethod.GET)
	public String firstPageShow() {
		return "/sample/firstPage";
	}

	/**
	 * 2番目の画面を表示します。
	 *
	 * @param form
	 * @return response
	 */
	@RequestMapping(value = "/first/next", method = RequestMethod.POST)
	public String firstPageNext(@ModelAttribute("form") SessionScopedBeanSampleForm form) {

		bean.setTestField(form.getTestField());
		return "/sample/secondPage";
	}
}
