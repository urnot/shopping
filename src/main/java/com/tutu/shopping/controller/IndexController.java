package com.tutu.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class IndexController {
	
	@RequestMapping(value= {"/","","index"})
	public String toIndex() {
		return "index";
	}
	@RequestMapping(value= {"/contact"})
	public String toContact() {
		return "contact";
	}
}
