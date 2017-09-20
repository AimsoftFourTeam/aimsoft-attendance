package jp.co.aimsoft.attendance.sample.mybatisTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.aimsoft.attendance.sample.mybatisTest.model.SessionBeanSample;

@Controller
@RequestMapping("iwai")
public class SessionScopedBeanSampleAnotherController {

	@Autowired
	private SessionBeanSample bean;

	/**
	 * 3番目の画面を表示します。
	 *
	 * @param form
	 * @return response
	 */
	@RequestMapping(value = "/second/next", method = RequestMethod.POST)
	public String secondPageNext() {

		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
		System.out.println("2番目の画面表示時点でのテストフィールド:" + bean.getTestField());
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");

		return "/sample/thirdPage";
	}

	/**
	 * 3番目の画面を表示後のセッションの中身を確認します。
	 *
	 * @param form
	 * @return response
	 */
	@RequestMapping(value = "/third/next", method = RequestMethod.POST)
	public String thirdPageResult() {

		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
		System.out.println("3番目の画面表示時点でのテストフィールド:" + bean.getTestField());
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");

		// リダイレクトによる遷移
		return "redirect:http://localhost:8080/aimsoft-attendance/";
	}
}
