package jp.co.aimsoft.attendance.sample.mybatisTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.aimsoft.attendance.sample.mybatisTest.dao.UserMapper;
import jp.co.aimsoft.attendance.sample.mybatisTest.dao.domain.UserDto;

/**
 * ユーザーロジック.
 */
@Service
@Transactional
public class UserServiceImpl {

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
	public void addUser(UserDto inputModel) {

		mapper.add(inputModel);
	}

	/**
	 * 引数のユーザーIDを元に全件ユーザーを取得します。
	 * 
	 * @param userId
	 *            ユーザーID
	 * @return UserModel ユーザーモデル
	 */
	@Transactional
	public List<UserDto> findByUserId() {

		List<UserDto> resultModel = mapper.getAllUser();

		return resultModel;
	}

}
