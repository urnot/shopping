package com.tutu.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutu.shopping.dao.MessageRepository;
import com.tutu.shopping.entity.Message;

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
		List<Message> list = messageRepository.findAll();
		map.addAttribute("msgs", list);

		return "manager";
	}
}
