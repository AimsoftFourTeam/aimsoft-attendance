package jp.co.aimsoft.attendance.sample.suggest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jp.co.aimsoft.attendance.sample.suggest.model.UserNameKeyAssist;

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
		viewable.setViewName("sample/tapsuggest");

		return viewable;
	}

	/**
	 * // * tapsuggestのデータを返すだけのテスト<br/>
	 * ajaxテスト用 色々やり方があるから迷っている<br/>
	 * あとでControllerの単位とかは考える。
	 * 
	 * @return response
	 */
	@ResponseBody
	@RequestMapping(value = "/getDataFortapSuggestLib", method = RequestMethod.POST)
	public List<UserNameKeyAssist> getJsonDataFortapSuggestLib() {

		return this.createTestData();
	}

	private List<UserNameKeyAssist> createTestData() {
		List<UserNameKeyAssist> list = new ArrayList<>();
		list.add(new UserNameKeyAssist("倉田", "kurata", "クラタ", "くらた"));
		list.add(new UserNameKeyAssist("岩井", "iwai", "イワイ", "いわい"));
		list.add(new UserNameKeyAssist("高橋", "takahashi", "タカハシ", "たかはし"));
		return list;
	}

}
