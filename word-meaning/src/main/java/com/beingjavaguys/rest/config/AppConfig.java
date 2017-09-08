package com.beingjavaguys.rest.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.beingjavaguys.rest", "com.beingjavaguys" })
@ImportResource({ "classpath:/com/beingjavaguys/rest/resources/spring-servlet.xml",
		"classpath:/com/beingjavaguys/rest/resources/spring.xml" })
public class AppConfig {

	@Autowired
	DataSource userDBDataSource;

	@Autowired
	DataSource wordDBdataSource;

	@Bean
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(userDBDataSource);
	}

	@Bean
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return new NamedParameterJdbcTemplate(wordDBdataSource);
	}

}