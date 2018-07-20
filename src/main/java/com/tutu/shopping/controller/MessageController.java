package com.tutu.shopping.controller;

import com.tutu.shopping.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @Autowired
    MessageService messageService;


}
