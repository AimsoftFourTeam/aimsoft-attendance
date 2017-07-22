package jp.co.aimsoft.attendance.sample.mybatisTest.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import jp.co.aimsoft.attendance.sample.mybatisTest.dao.domain.UserDto;

/**
 * ユーザー情報マッパー.
 */
@Mapper
public interface UserMapper {

	// TODO DB環境が整ったのち復活させる
	/** SELECT全件. */
	@Select("SELECT * FROM USERMASTER")
	List<UserDto> findAll();

	/** INSERT. */
	void addUser(UserDto dto);

	/** UPDATE. */
	void updateOne(UserDto dto);

	/** DELETE. */
	@Delete("DELETE FROM USERMASTER")
	void deleteAll();
}