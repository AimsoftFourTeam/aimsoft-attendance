package jp.co.aimsoft.attendance.sample.mybatisTest.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.aimsoft.attendance.sample.common.util.SecurityUtil;
import jp.co.aimsoft.attendance.sample.mybatisTest.dao.UserMapper;
import jp.co.aimsoft.attendance.sample.mybatisTest.dao.domain.UserDto;
import jp.co.aimsoft.attendance.sample.mybatisTest.model.UserModel;
import jp.co.aimsoft.attendance.sample.mybatisTest.service.UserService;

/**
 * ユーザーロジック.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;

	/** コンストラクタ. */
	public UserServiceImpl() {

	}

	/**
	 * DBアクセスし、1件ユーザーを登録します。
	 *
	 * @param inputModel
	 *            ユーザーモデル.
	 */
	@Transactional
	public void addUser(UserModel model) {

		String password = SecurityUtil.getHashedPassword(model.getUserId(), model.getPassword());
		UserDto dto = new UserDto();
		BeanUtils.copyProperties(model, dto);
		dto.setPassword(password);
		mapper.addUser(dto);
	}

	/**
	 * ユーザーを全件を取得します。
	 *
	 * @return UserModel ユーザーモデル
	 */
	@Transactional
	public List<UserDto> findAll() {

		List<UserDto> resultModel = mapper.findAll();

		return resultModel;
	}

	/**
	 * ユーザーIDを元にユーザー情報を1件更新します。
	 *
	 * @param dto
	 *            ユーザーDTO
	 */
	@Transactional
	public void updateOne(UserModel model) {

		UserDto dto = new UserDto();
		BeanUtils.copyProperties(model, dto);
		mapper.updateOne(dto);
	}

	/**
	 * User_Master全件削除します。
	 */
	@Transactional
	public void deleteAll() {
		mapper.deleteAll();
	}

	/**
	 * User_Masterを1件削除します。
	 * 
	 * @param userId
	 */
	@Transactional
	public void deleteOne(String userId) {
		mapper.deleteOne(userId);
	}

	/**
	 * UserIdをもとに対応するパスワードを取得します。
	 * 
	 * @param userId
	 *            UserId
	 */
	@Transactional
	public String getPassword(String userId) {
		UserDto dto = mapper.findOne(userId);
		return dto != null ? dto.getPassword() : "";
	}

	/**
	 * UserIdをもとに対応するユーザー情報を取得します。
	 * 
	 * @param model
	 *            ユーザーモデル.
	 * @return UserModel
	 */
	@Transactional
	public UserModel getUserByUserId(UserModel model) {

		UserDto dto = mapper.findOne(model.getUserId());
		BeanUtils.copyProperties(dto, model);
		return model;
	}

}