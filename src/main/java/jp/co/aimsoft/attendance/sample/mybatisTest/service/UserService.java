package jp.co.aimsoft.attendance.sample.mybatisTest.service;

import java.util.List;

import jp.co.aimsoft.attendance.sample.mybatisTest.dao.domain.UserDto;

public interface UserService {
	// TODO DB環境が整ったのち復活させる
	void addUser(List<UserDto> dto);

	List<UserDto> findByUserId();

}
