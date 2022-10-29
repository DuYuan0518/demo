package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.QueryStuCondition;
import com.example.demo.dto.QueryUserCondition;
import com.example.demo.entity.Stu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public Page<Stu> page(Pageable pageable, QueryUserCondition condition){
        return userDao.page(pageable, condition);
    }
}
