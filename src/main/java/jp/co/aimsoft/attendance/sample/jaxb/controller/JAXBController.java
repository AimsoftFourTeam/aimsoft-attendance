package jp.co.aimsoft.attendance.sample.jaxb.controller;

import java.io.File;

import javax.xml.bind.JAXB;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.aimsoft.attendance.stub.model.SampleStubDtos;

/**
 * JAXBサンプル.
 */
@Controller
@RequestMapping("iwai")
public class JAXBController {

	/**
	 * 決められたパスからファイルを取得してdtoに変換しレスポンスを返却します。
	 */
	@RequestMapping(value = "/jaxb/sample", method = RequestMethod.GET)
	public ModelAndView sampleJAXBTest() {

		// FIXME 相対パス指定方法
		File file = new File(
				"C:\\Users\\Rigel\\Desktop\\workspace0828-2\\aimsoft-attendance\\src\\main\\java\\jp\\co\\aimsoft\\attendance\\stub\\xml\\sampleStubXxx.xml");

		SampleStubDtos dtos = JAXB.unmarshal(file, SampleStubDtos.class);
		dtos.getSampleStubDtoList().removeIf(d -> {
			return d == null;
		});

		// あんまりよくないかもだけどこういう設定方法もあります。
		ModelAndView mav = new ModelAndView() {
			{
				setViewName("sample/jaxb");
				addObject("dtos", dtos);
			}
		};

		return mav;
	}

}
