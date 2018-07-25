package com.tutu.shopping.controller;

import com.tutu.shopping.dao.MessageRepository;
import com.tutu.shopping.entity.Message;
import com.tutu.shopping.service.MessageService;
import com.tutu.shopping.util.IpUtil;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping(value = "/board")
public class MessageController {
	@Autowired
	MessageRepository messageRepository;

	@GetMapping(value = "/message")
	public String sayHello() {
		return "test";
	}

	/**
	 * 跳转到留言板首页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index")
	public String toBoard() {
		return "board";
	}

	/**
	 * 保存留言的方法 json ajax
	 * 
	 * @param name
	 * @param content
	 * @return
	 */
	@PostMapping(value = "/save")
	@ResponseBody
	public Message leaveMessage(@RequestParam("name") String name, @RequestParam("content") String content,
			HttpServletRequest request) {
		String remoteIp=IpUtil.getIpAddr(request);
		Message m = new Message();
		m.setRemoteUrl(remoteIp);
		m.setName(name);
		m.setContent(content);
		//System.out.println(remoteIp);
		return messageRepository.save(m);
	}

	/**
	 * 跳转到全部留言页面
	 * 
	 * @return
	 */
	@GetMapping(value = "/list")
	public String toList() {
		return "msglist";

	}

	/**
	 * query全部留言页面
	 * 
	 * @return
	 */
	@GetMapping(value = "/query")
	@ResponseBody
	public List<Message> queryList() {
		return messageRepository.findAll();

	}
	@PostMapping(value = "/check")
	@ResponseBody
	public boolean check(@PathVariable("name") String name) {
		System.out.println(name);
		return false;
	}

}
