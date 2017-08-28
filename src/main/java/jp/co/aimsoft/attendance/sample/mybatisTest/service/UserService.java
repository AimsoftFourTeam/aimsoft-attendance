package jp.co.aimsoft.attendance.sample.mybatisTest.service;

import java.util.List;

import jp.co.aimsoft.attendance.sample.mybatisTest.dao.domain.UserDto;
import jp.co.aimsoft.attendance.sample.mybatisTest.model.UserModel;

public interface UserService {

	/**
	 * @param dto
	 *            ユーザーDTO
	 * @see jp.co.aimsoft.attendance.sample.mybatisTest.service.UserService#addUser(UserDto)
	 */
	void addUser(UserModel model);

	/**
	 * @return UserDto ユーザーDTO
	 * @see jp.co.aimsoft.attendance.sample.mybatisTest.service.UserService#findAll()
	 */
	List<UserDto> findAll();

	/**
	 * @param dto
	 *            ユーザーDTO
	 * @see jp.co.aimsoft.attendance.sample.mybatisTest.service.UserService#updateOne(UserDto)
	 */
	void updateOne(UserModel dto);

	/**
	 * @see jp.co.aimsoft.attendance.sample.mybatisTest.service.UserService#deleteAll()
	 */
	void deleteAll();

	/**
	 * @param userId
	 *            ユーザーID
	 * @see jp.co.aimsoft.attendance.sample.mybatisTest.service.UserService#deleteOne()
	 */
	void deleteOne(String userId);
	
	/**
	 * @param userId userId
	 * 
	 * @see jp.co.aimsoft.attendance.sample.mybatisTest.service.UserService#getPassword(String)
	 */
	String getPassword(String userId);

}