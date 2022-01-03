package com.du.rems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

//@RestController
//public class MailController {
//
//    @Resource
//    private JavaMailSenderImpl javaMailSender;
//
//    @RequestMapping("/sendmail")
//    public void send(){
//        SimpleMailMessage message = new SimpleMailMessage();
//
//        message.setFrom("15929993389@163.com");
//        message.setTo();
//    }
//}
