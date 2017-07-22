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
public class UserServiceImpl implements UserService {
	// TODO DB環境が整ったのち復活させる
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
	public void addUser(UserDto dto) {
		mapper.addUser(dto);
	}

	/**
	 * 引数のユーザーIDを元に全件ユーザーを取得します。
	 *
	 * @param userId
	 *            ユーザーID
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
	public void updateOne(UserDto dto) {
		mapper.updateOne(dto);
	}

	/**
	 * UserMaster全件削除します。
	 */
	@Transactional
	public void deleteAll() {
		mapper.deleteAll();
	}

}