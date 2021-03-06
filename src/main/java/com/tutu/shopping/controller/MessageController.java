package com.tutu.shopping.controller;

import com.sun.org.apache.regexp.internal.recompile;
import com.tutu.shopping.dao.MessageRepository;
import com.tutu.shopping.entity.Message;
import com.tutu.shopping.service.MessageService;
import com.tutu.shopping.util.AddressUtils;
import com.tutu.shopping.util.IpUtil;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
	public String leaveMessage(@RequestParam("name") String name, @RequestParam("content") String content,
			HttpServletRequest request) {
		String remoteIp = IpUtil.getIpAddr(request);

		Message m = new Message();
		m.setRemoteUrl(remoteIp);
		m.setName(name);
		m.setPublishTime(new Date());
		m.setContent(content);
		String city = "";
		if (remoteIp.equals("0:0:0:0:0:0:0:1") || remoteIp.equals("127.0.0.11") || remoteIp.equals("localhost")
				|| remoteIp == null) {
			city = "本机测试或空";
		} else {

			try {
				city = AddressUtils.getAddresses(remoteIp, "utf-8");
			} catch (Exception e) {
				city = "未知地区";
				System.out.println(e.getMessage());
			}
		}

		m.setCity(city);
		System.out.println(m);
		messageRepository.save(m);
		// System.out.println(remoteIp);
		return "ok";
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
	public String queryList(Model map) {
		List<Message> list = messageRepository.findAll();
		map.addAttribute("msgs", list);
		return "msglist";

	}

	/**
	 * getbyid
	 * 
	 * @return
	 */
	@GetMapping(value = "/get/{id}")
	@Transactional
	@ResponseBody

	public Message queryById(@PathVariable("id") Integer id) {
		return messageRepository.findById(id).orElse(null);

	}

	@PostMapping("/update/{id}")
	@ResponseBody
	@Transactional
	public String update(@PathVariable("id") Integer id) {
		Message m = messageRepository.findById(id).orElse(null);
		if (m.isFlag()) {// true
			m.setFlag(false);
		} else {
			m.setFlag(true);
		}
		messageRepository.saveAndFlush(m);
		return "success";
	}

	@PostMapping(value = "/check")
	@ResponseBody
	public boolean check(@PathVariable("name") String name) {
		System.out.println(name);
		return false;
	}

}
