package com.example.demo.api;

import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("api/vi/login")
@Api(tags = "用户登录api")
public class LoginController {

    @Resource
    private UserService userService;






}
