package jp.co.aimsoft.attendance.sample.redirect;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("redirect")
public class RedirectController {

	/**
	 * 初期表示. 303
	 * POSTになる
	 * @return response
	 */
	@RequestMapping("/see_other/tohtml")
	public ModelAndView tapsuggestSample() {

		ModelAndView viewable = new ModelAndView();
		viewable.setStatus(HttpStatus.SEE_OTHER);
		viewable.setViewName("sample/empty");

		return viewable;
	}

	/**
	 * 初期表示. 307
	 *　POSTになる
	 * @return response
	 */
	@RequestMapping("/temporary_redirect/tohtml")
	public ModelAndView tapsuggestSample2() {

		ModelAndView viewable = new ModelAndView();
		viewable.setStatus(HttpStatus.TEMPORARY_REDIRECT);
		viewable.setViewName("sample/empty");

		return viewable;
	}

	/**
	 * 初期表示. 307 この場合はPOSTではなく、GET送信になる。 GET
	 * http://192.168.2.109:8080/skill-spider/ss01/register HTTP/1.1 Host:
	 * 192.168.2.109:8080 Connection: keep-alive User-Agent: Mozilla/5.0
	 * (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko)
	 * Chrome/61.0.3163.100 Safari/537.36 Upgrade-Insecure-Requests: 1 Accept:
	 * text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,
	 * ;q=0.8*Accept-Encoding:gzip,deflate*Accept-Language:ja,en-US;q=0.8,en;q=0.6*Cookie:JSESSIONID=80F
	 * FD10FFB01F6DE0B92E5B9255BED09
	 *
	 * @return response
	 */
	@RequestMapping("/temporary_redirect/serverdirect")
	public ModelAndView tapsuggestSample3() {

		ModelAndView viewable = new ModelAndView();
		viewable.setStatus(HttpStatus.TEMPORARY_REDIRECT);
		viewable.setViewName("redirect:http://192.168.2.109:8080/skill-spider/ss01/register");

		return viewable;
	}
	@RequestMapping("/see_other/serverdirect")
	public RedirectView tapsuggestSample4() {
		RedirectView redirectView = new RedirectView();
	    redirectView.setUrl("http://192.168.2.109:8080/skill-spider/ss01/register");
	    redirectView.setStatusCode(HttpStatus.SEE_OTHER);

//	    GET http://192.168.2.109:8080/skill-spider/ss01/register HTTP/1.1
//	    	Host: 192.168.2.109:8080
//	    	Connection: keep-alive
//	    	User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36
//	    	Upgrade-Insecure-Requests: 1
//	    	Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
//	    	Accept-Encoding: gzip, deflate
//	    	Accept-Language: ja,en-US;q=0.8,en;q=0.6
//	    	Cookie: JSESSIONID=80FFD10FFB01F6DE0B92E5B9255BED09

		return redirectView;
	}

}
