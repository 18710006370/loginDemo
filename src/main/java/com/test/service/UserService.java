package com.test.service;

import com.test.common.RestResp;
import com.test.data.UserRepo;
import com.test.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author anonymity
 * @create 2018-12-21 18:27
 **/
@Slf4j
@Service
public class UserService {

    @Resource
    private UserRepo userRepo;

    public RestResp register(User user){
        return userRepo.findByName(user.getName()).map(u -> RestResp.fail()).orElseGet(() -> {
            User u = userRepo.save(user);
            log.info("{} registered", u);
            return RestResp.success("注册成功");
        });
    }
}
