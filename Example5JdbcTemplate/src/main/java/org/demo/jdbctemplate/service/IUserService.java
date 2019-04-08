package org.demo.jdbctemplate.service;

public interface IUserService {
	void create(String name, Integer age); 
	void deleteByName(String name);
	Integer getAllUsers(); 
	void deleteAllUsers(); 
}
