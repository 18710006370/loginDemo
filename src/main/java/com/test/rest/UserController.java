package com.test.rest;

import com.test.data.RestResp;
import com.test.data.UserRepo;
import com.test.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * Created by Luo_xuri on 2017/9/29.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger LOG = LoggerFactory.getLogger(getClass());

    @Resource
    private UserRepo userRepo;

    @PostMapping("/register")
    public RestResp register(@RequestBody User user){
        return userRepo.findByName(user.getName()).map(u -> RestResp.fail()).orElseGet(() -> {
           User u = userRepo.save(user);
           LOG.info("{} registered", u);
           return RestResp.success("注册成功");
        });
    }
}
