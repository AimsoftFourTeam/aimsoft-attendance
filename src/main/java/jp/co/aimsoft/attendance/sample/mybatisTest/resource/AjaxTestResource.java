package jp.co.aimsoft.attendance.sample.mybatisTest.resource;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import jp.co.aimsoft.attendance.sample.mybatisTest.model.UserModel;
import jp.co.aimsoft.attendance.sample.mybatisTest.service.UserService;

/**
 * Ajaxの動作確認用Resource
 */
@RestController
@RequestMapping("iwai")
public class AjaxTestResource {

	@Autowired
	private UserService service;

	/** コンストラクタ. */
	public AjaxTestResource() {

	}

	/**
	 * UserIdを元に1件ユーザー情報を取得し、返却します。
	 * 
	 * 
	 * @param inputJson
	 *            ajaxリクエス
	 * @return resultJson
	 */
	@RequestMapping(value = "/ajaxTest/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserModel getUserByUserId(@RequestBody String inputJson) {

		ObjectMapper mapper = new ObjectMapper();
		UserModel model = new UserModel();
		try {
			model = mapper.readValue(inputJson, UserModel.class);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		// RestControllerを付与しているため、ResponseBodyアノテーションおよびJSONへの明示的変換は不要
		UserModel resultModel = service.getUserByUserId(model);

		return resultModel;
	}

}