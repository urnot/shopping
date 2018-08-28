package com.tutu.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutu.shopping.dao.MessageRepository;

@Controller
public class UserController {
	@Autowired
	MessageRepository messageRepository;

	@GetMapping(value = "/login")
	public String userlogin() {
		return "index";
	}

	@GetMapping(value = "/mana")
	public String getAll(Model map) {
		map.addAttribute("msgs", messageRepository.findAll());

		return "manager";
	}
}
