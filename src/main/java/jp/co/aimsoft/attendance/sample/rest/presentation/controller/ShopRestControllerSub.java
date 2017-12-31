package jp.co.aimsoft.attendance.sample.rest.presentation.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jp.co.aimsoft.attendance.sample.rest.logic.model.ShopModel;
import jp.co.aimsoft.attendance.sample.rest.logic.service.ShopService;
import jp.co.aimsoft.attendance.sample.rest.presentation.form.ShopForm;

@RestController
@RequestMapping("api/shopSub")
public class ShopRestControllerSub {

	@Autowired
	private ShopService service;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void createOne(@ModelAttribute ShopForm form) {

		ShopModel model = new ShopModel();
		BeanUtils.copyProperties(form, model);
		service.register(model);
	}

	@RequestMapping(method = RequestMethod.GET, value = "{shopId}")
	@ResponseStatus(HttpStatus.OK)
	public ShopModel getShop(@PathVariable String shopId) {

		System.out.println("SubModule");
		ShopModel model = service.getShop(shopId);
		return model;
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@RequestBody ShopForm form) {

		ShopModel model = new ShopModel();
		BeanUtils.copyProperties(form, model);
		service.update(model);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{shopId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String shopId) {

		service.delete(shopId);
	}

}
