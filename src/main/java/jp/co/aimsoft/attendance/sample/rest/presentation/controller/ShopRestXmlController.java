package jp.co.aimsoft.attendance.sample.rest.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jp.co.aimsoft.attendance.sample.rest.logic.model.ShopModel;
import jp.co.aimsoft.attendance.sample.rest.logic.service.ShopService;

@RestController
@RequestMapping("api/shop/xml")
public class ShopRestXmlController {

	@Autowired
	private ShopService service;

	@RequestMapping(method = RequestMethod.GET, value = "{shopId}")
	@ResponseStatus(HttpStatus.OK)
	public ShopModel getShopByXml(@PathVariable String shopId) {

		ShopModel model = service.getShop(shopId);
		return model;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/manualXml")
	@ResponseStatus(HttpStatus.OK)
	public String getShopByXmlForManualString(@PathVariable String shopId) {

		// 閉じタグを変更してみる。
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" + "<shopModel>"
				+ "<shopId>20</shopId>" + "<shopName>hogehoge</shopName>" + "<shopModel>";

		return xml;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/schema")
	@ResponseStatus(HttpStatus.OK)
	public String getShopByXmlForSchema() {

		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" + "<shopModel>"
				+ "<shopId></shopId>" + "<shopName>hogehoge</shopName>" + "</shopModel>";

		return xml;
	}
}
