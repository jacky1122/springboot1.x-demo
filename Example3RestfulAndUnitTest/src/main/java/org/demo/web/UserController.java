package org.demo.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.demo.entity.User;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users")
public class UserController {

	private static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>()); 
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public List<User> getUserList(){
		List<User> r = new ArrayList<User>(users.values()); 
		return r; 
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String postUser(@ModelAttribute User user ) {
		users.put(user.getId(), user); 
		return "success"; 
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public User getUser(@PathVariable Long id) {
		return users.get(id); 
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String putUser(@PathVariable Long id, @ModelAttribute User user) {
		User u = users.get(id); 
		u.setName(user.getName());
		u.setAge(user.getAge());
		users.put(id,  u); 
		return "success";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public String deleteUser(@PathVariable Long id) {
		users.remove(id); 
		return "success";
	}
}
