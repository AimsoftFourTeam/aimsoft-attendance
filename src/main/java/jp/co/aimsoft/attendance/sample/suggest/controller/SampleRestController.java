package jp.co.aimsoft.attendance.sample.suggest.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/")
public class SampleRestController {

	/**
	 * 文字列の連想配列でクライアント側にて受け取る為の戻り
	 * 
	 * @return response
	 */
	@RequestMapping(value = "/getDataFortapSuggestLib2", method = RequestMethod.POST)
	public List<List<String>> getJsonDataFortapSuggestLib2() {

		return this.createTestData();
	}

	private List<List<String>> createTestData() {
		List<List<String>> lists = new ArrayList<>();
		lists.add(Arrays.asList("倉田", "kurata", "クラタ", "くらた"));
		lists.add(Arrays.asList("岩井", "iwai", "イワイ", "いわい"));
		lists.add(Arrays.asList("高橋", "takahashi", "タカハシ", "たかはし"));
		lists.add(Arrays.asList("佐藤", "sato", "サトウ", "さとう"));
		lists.add(Arrays.asList("伊藤", "ito", "イトウ", "いとう"));
		return lists;
	}

	/** コンストラクタ. */
	public SampleRestController() {

	}
}
