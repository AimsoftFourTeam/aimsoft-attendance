package jp.co.aimsoft.attendance.sample.mybatisTest.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.aimsoft.attendance.sample.mybatisTest.form.NameListForm;

@Controller
public class NameListController {

	@RequestMapping(value = "/NameBook", method = RequestMethod.POST)
	public ModelAndView NameList(@ModelAttribute NameListForm nameform) {
		ModelAndView NameList = new ModelAndView();
		NameList.setViewName("sample/EgitHome");
		NameList.addObject("model", nameform);
		NameList.addObject("syainitems", getListItems());
		return NameList;
	}

	private Map<Integer, ArrayList<String>> getListItems() {
		Map<Integer, ArrayList<String>> ListItems = new LinkedHashMap<Integer, ArrayList<String>>();

		ListItems.put(0, new ArrayList<String>());

		ArrayList<String> kinura = new ArrayList<String>();
		kinura.add("木村　拓哉");
		kinura.add("2000年1月5日");
		kinura.add("経理部");
		kinura.add("本社");
		ListItems.put(1, kinura);

		ArrayList<String> nakai = new ArrayList<String>();
		nakai.add("中居　正広");
		nakai.add("2003年12月1日");
		nakai.add("営業部");
		nakai.add("本社");
		ListItems.put(2, nakai);

		ArrayList<String> inagaki = new ArrayList<String>();
		inagaki.add("稲垣　吾郎");
		inagaki.add("1998年6月15日");
		inagaki.add("製造部");
		inagaki.add("大阪支店");
		ListItems.put(3, inagaki);

		ArrayList<String> kusanagi = new ArrayList<String>();
		kusanagi.add("草彅　剛");
		kusanagi.add("2010年8月25日");
		kusanagi.add("新事業部");
		kusanagi.add("横浜支店");
		ListItems.put(4, kusanagi);

		ArrayList<String> katori = new ArrayList<String>();
		katori.add("香取　慎吾");
		katori.add("1997年3月31日");
		katori.add("役員");
		katori.add("本社");
		ListItems.put(5, katori);

		return ListItems;
	}

}
