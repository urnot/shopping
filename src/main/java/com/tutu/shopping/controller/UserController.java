package com.tutu.shopping.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping(value = "/login")
	public String userlogin() {
		if (true) {
			return "success";
		} else {
			return "fail";
		}
	}
}
