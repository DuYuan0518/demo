package com.example.demo.api;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/vi/register")
@Api(tags = "用户注册Api")
public class RegisterController {

}
