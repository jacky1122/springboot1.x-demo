package org.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloThymeleaf {
	@RequestMapping("/")
	public String index(ModelMap map) {
		map.addAttribute("host", "http://www.baidu.com");
		return "index"; 
	}
}
