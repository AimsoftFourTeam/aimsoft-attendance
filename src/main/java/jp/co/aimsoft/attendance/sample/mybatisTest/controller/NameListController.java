package jp.co.aimsoft.attendance.sample.mybatisTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.aimsoft.attendance.sample.mybatisTest.form.NameListForm;
import jp.co.aimsoft.attendance.sample.mybatisTest.helper.NameListHelper;

@Controller
public class NameListController {

	@Autowired
	private NameListHelper helper;

	@RequestMapping(value = "/NameBook", method = RequestMethod.POST)
	public ModelAndView NameList(@ModelAttribute NameListForm nameform) {
		ModelAndView NameList = new ModelAndView();
		NameList.setViewName("sample/EgitHome");
		NameList.addObject("model", nameform);
		NameList.addObject("syainitems", helper.getListItems());
		return NameList;
	}

}
