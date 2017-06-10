package jp.co.aimsoft.attendance.sample.suggest.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.SerializationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
		viewable.setViewName("/sample/tapsuggest");

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

	/**
	 * // * tapsuggestのデータを返すだけのテスト<br/>
	 * ajaxテスト用 色々やり方があるから迷っている<br/>
	 * あとでControllerの単位とかは考える。
	 * 
	 * @return response
	 */
	@ResponseBody
	@RequestMapping(value = "/getDataFortapSuggestLib2", method = RequestMethod.POST)
	public List<List<String>> getJsonDataFortapSuggestLib2() {
		return this.createTestData2();
	}

	/**
	 * // * tapsuggestのデータを返すだけのテスト<br/>
	 * ajaxテスト用 色々やり方があるから迷っている<br/>
	 * あとでControllerの単位とかは考える。
	 * 
	 * @return response
	 */
	@ResponseBody
	@RequestMapping(value = "/getDataFortapSuggestLib1", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
	public String getJsonDataFortapSuggestLib1() {
		ObjectMapper mapper = new ObjectMapper();
		// produces="text/plain;charset=utf-8"については、Springの設定ファイルで解消できるはず。
		String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(this.createTestData());
			System.out.println("jsonString:" + jsonString);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// chromeのコンソールにて文字化けしている。
		// 文字コードをutf8にしなければいけない・・・設定が必要。
		return jsonString;
	}

	private List<UserNameKeyAssist> createTestData() {
		List<UserNameKeyAssist> list = new ArrayList<>();
		list.add(new UserNameKeyAssist("倉田", "kurata", "クラタ", "くらた"));
		list.add(new UserNameKeyAssist("岩井", "iwai", "イワイ", "いわい"));
		list.add(new UserNameKeyAssist("高橋", "takahashi", "タカハシ", "たかはし"));
		return list;
	}

	private List<List<String>> createTestData2() {
		List<List<String>> lists = new ArrayList<>();
		lists.add(Arrays.asList("倉田", "kurata", "クラタ", "くらた"));
		lists.add(Arrays.asList("岩井", "iwai", "イワイ", "いわい"));
		lists.add(Arrays.asList("高橋", "takahashi", "タカハシ", "たかはし"));
		lists.add(Arrays.asList("佐藤", "sato", "サトウ", "さとう"));
		lists.add(Arrays.asList("伊藤", "ito", "イトウ", "いとう"));
		return lists;
	}
}
