package jp.co.aimsoft.attendance.sample.suggest.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/suggest")
public class SuggestResource {

	/**
	 * // * tapsuggestのデータを返すだけのテスト<br/>
	 * ajaxテスト用 色々やり方があるから迷っている<br/>
	 * あとでControllerの単位とかは考える。
	 * 
	 * @return response
	 */
	@RequestMapping(value = "/getDataFortapSuggestLib", method = RequestMethod.POST)
	public List<List<String>> getJsonDataFortapSuggestLib() {
		System.out.println("test");
		return this.createTestData2();
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
