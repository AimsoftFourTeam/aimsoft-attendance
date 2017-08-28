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

	/** SELECT全件. */
	@Select("SELECT * FROM user_master")
	List<UserDto> findAll();

	/** INSERT. */
	void addUser(UserDto dto);

	/** UPDATE. */
	void updateOne(UserDto dto);

	/** DELETE. */
	@Delete("DELETE FROM user_master")
	void deleteAll();

	/** SELECT1件. */
	UserDto findOne(String userId);

	/** DELETE1件. */
	void deleteOne(String userId);
}