package com.example.demo.service;

import com.example.demo.dao.StuDao;
import com.example.demo.dto.QueryStuCondition;
import com.example.demo.entity.Stu;
import com.example.demo.utils.PageParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StuService {

    @Resource
    private StuDao stuDao;

    public Page<Stu> page(Pageable pageable, QueryStuCondition condition){
        return stuDao.page(pageable, condition);
    }
}
