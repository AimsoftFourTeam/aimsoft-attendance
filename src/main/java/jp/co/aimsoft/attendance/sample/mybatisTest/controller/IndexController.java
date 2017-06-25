package jp.co.aimsoft.attendance.sample.mybatisTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	/**
	 * index.htmlを表示します。<br />
	 * 純粋なSpringBootだとindex.htmlを自動認識するようですが、<br />
	 * 思うようにいかなかったため、index.htmlを呼び出すControllerを用意し対応します。<br />
	 * frameworkにて解決できるか検証は続ける予定です。<br />
	 *
	 * @return index.html
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showIndex() {
		return "index";
	}

}
