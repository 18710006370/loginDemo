package com.test.rest;

import com.test.common.Mail;
import com.test.common.RestResp;
import com.test.domain.User;
import com.test.service.MailService;
import com.test.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private MailService mailService;
    @PostMapping("/register")
    public RestResp register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/sendmail")
    public RestResp sendMail(@RequestBody Mail mail){
        return mailService.sendMail("teeee@126.com", "test title", "taishuai");
    }

}
