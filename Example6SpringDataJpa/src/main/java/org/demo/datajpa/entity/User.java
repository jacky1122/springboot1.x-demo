package org.demo.datajpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable=false)
	private String name; 
	@Column(nullable=false)
	private Integer age; 

	public User(String name, Integer age) {
		this.name = name; 
		this.age = age; 
	}
}
