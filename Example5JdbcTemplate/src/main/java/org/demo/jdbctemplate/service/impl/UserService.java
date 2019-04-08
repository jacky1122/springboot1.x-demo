package org.demo.jdbctemplate.service.impl;

import org.demo.jdbctemplate.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public void create(String name, Integer age) {
		jdbcTemplate.update("insert into user(name, age) values(?, ?)", name, age); 
	}
	
	

	@Override
	public void deleteByName(String name) {
		jdbcTemplate.update("delete from user where name = ? ", name); 
	}

	@Override
	public Integer getAllUsers() {
		return jdbcTemplate.queryForObject("select count(1) from user", Integer.class);
	}

	@Override
	public void deleteAllUsers() {
		jdbcTemplate.update("delete from user"); 
	}
		

}
