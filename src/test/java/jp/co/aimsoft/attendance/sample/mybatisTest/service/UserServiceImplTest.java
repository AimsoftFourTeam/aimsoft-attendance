package jp.co.aimsoft.attendance.sample.mybatisTest.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;

import jp.co.aimsoft.attendance.sample.mybatisTest.dao.UserMapper;
import jp.co.aimsoft.attendance.sample.mybatisTest.dao.domain.UserDto;
import mockit.Deencapsulation;
import mockit.Expectations;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class UserServiceImplTest {

	private UserServiceImpl target = new UserServiceImpl();

	public UserServiceImplTest() {

	}

	/**
	 * jmeter用のテストコード.
	 */
	@Test
	public void test_getPassword_正常(@Mocked UserMapper mapper) {

		// 事前準備
		new Expectations() {
			{
				mapper.findOne(anyString);
				result = new UserDto() {
					{
						setPassword("test");
					}
				};
			}
		};

		Deencapsulation.setField(target, mapper);

		// 実行
		String result = target.getPassword("testUser01");

		// 検証
		assertThat(result, equalTo("test"));
	}
}
