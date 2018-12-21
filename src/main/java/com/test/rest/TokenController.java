package com.test.rest;

import com.test.auth.JwtService;
import com.test.common.RestResp;
import com.test.data.UserRepo;
import com.test.data.UserTokenRepo;
import com.test.domain.NameAndPass;
import com.test.domain.UserToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/token")
public class TokenController {


    @Resource
    private UserRepo userRepo;
    @Resource
    private JwtService jwtService;
    @Resource
    private UserTokenRepo userTokenRepo;

    @PostMapping
    public RestResp enroll(@RequestBody NameAndPass user) {
        return userRepo.findByNameAndPassword(user.getUsername(), user.getPassword()).map(u -> {
            UserToken userToken = new UserToken(jwtService.generate(u));
            log.info("{} enrolled", user.getUsername());
            userToken = userTokenRepo.save(userToken);
            return RestResp.success(userToken);
        }).orElse(RestResp.fail());

    }
}
