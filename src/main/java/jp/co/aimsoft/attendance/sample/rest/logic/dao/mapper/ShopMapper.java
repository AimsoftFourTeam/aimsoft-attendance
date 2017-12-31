package jp.co.aimsoft.attendance.sample.rest.logic.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

import jp.co.aimsoft.attendance.sample.rest.logic.dao.domain.ShopDto;

@Mapper
public interface ShopMapper {

	/** POST(CREATE.INSERT). */
	void register(ShopDto dto);

	/** GET(SELECt). */
	ShopDto getShop(String id);

	/** PUT(UPDATE). */
	void update(ShopDto dto);

	/** DELETE(DELETE). */
	void delete(String id);
}
