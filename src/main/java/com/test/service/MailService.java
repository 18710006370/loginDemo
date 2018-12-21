package com.test.service;

import com.test.common.RestResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *  邮箱验证流程
 * 1、用户填写账号密码点击注册
 * 2、后台验证是否合法
 * 3、如果合法激活码置为0，开启邮件服务发送邮件
 * 4、用户收到邮件，点击连接，激活码置为1
 * @author anonymity
 * @create 2018-12-21 18:27
 **/
@Slf4j
@Service
public class MailService {

    @Value("${spring.mail.host}")
    private String sender;

    @Resource
    private JavaMailSender javaMailSender;

    /**
     * 邮箱超时，可以换QQ邮箱测试
     * @param receiver
     * @param title
     * @param text
     * @return
     */
    public RestResp sendMail(String receiver, String title, String text){
        try {
            // 建立邮件消息
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            // 发送者
            simpleMailMessage.setFrom(sender);
            // 接受者
            simpleMailMessage.setTo(receiver);
            // 发送的标题
            simpleMailMessage.setSubject(title);
            // 发送的内容
            simpleMailMessage.setText(text);
            javaMailSender.send(simpleMailMessage);
            return RestResp.success();
        }catch (Exception e){
            log.error("send mail failed", e);
        }
        return RestResp.fail();
    }
}
