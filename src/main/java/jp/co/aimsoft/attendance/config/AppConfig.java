package jp.co.aimsoft.attendance.config;

import java.nio.charset.Charset;
import java.util.Arrays;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;

@Configuration
@MapperScan("jp.co.aimsoft.attendance.sample.mybatisTest.dao")
public class AppConfig {

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
		return sessionFactory.getObject();
	}

	@Bean
	public StringHttpMessageConverter stringHttpMessageConverter() {

		StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();

		stringHttpMessageConverter
				.setSupportedMediaTypes(Arrays.asList(new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"))));
		stringHttpMessageConverter.setWriteAcceptCharset(false);
		return stringHttpMessageConverter;
	}
}
