package jp.co.aimsoft.attendance.sample.rest.logic.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.aimsoft.attendance.sample.rest.logic.dao.domain.ShopDto;
import jp.co.aimsoft.attendance.sample.rest.logic.dao.mapper.ShopMapper;
import jp.co.aimsoft.attendance.sample.rest.logic.model.ShopModel;

@Service
@Transactional
public class ShopService {

	@Autowired
	private ShopMapper mapper;

	public void register(ShopModel model) {

		ShopDto dto = new ShopDto();
		BeanUtils.copyProperties(model, dto);
		mapper.register(dto);
	}

	public ShopModel getShop(String shopId) {

		ShopDto dto = mapper.getShop(shopId);
		ShopModel model = new ShopModel();
		BeanUtils.copyProperties(dto, model);

		return model;
	}

	public void update(ShopModel model) {

		ShopDto dto = new ShopDto();
		BeanUtils.copyProperties(model, dto);
		mapper.update(dto);
	}

	public void delete(String shopId) {

		mapper.delete(shopId);
	}
}
