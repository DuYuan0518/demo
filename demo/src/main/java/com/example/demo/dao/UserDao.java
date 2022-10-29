package com.example.demo.dao;

import com.example.demo.dto.QueryStuCondition;
import com.example.demo.dto.QueryUserCondition;
import com.example.demo.entity.Stu;
import com.example.demo.entity.Stu_;
import com.example.demo.entity.User;
import com.example.demo.utils.BaseDao;
import com.example.demo.utils.SpecificationFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.List;

public interface UserDao extends BaseDao {
    default Page<Stu> page(Pageable pageable, QueryUserCondition condition) {
        Specification<Stu> spec = SpecificationFactory.builder();
        if (condition.getUserName() != null && StringUtils.hasText(condition.getUserName())) {
            String c = "%" + condition.getUserName() + "%";
            Specification<Stu> orSpec = SpecificationFactory.like(Stu_.KEY, c);
            spec = spec.and(orSpec);
        }
        if (condition.getUserPassword() != null && StringUtils.hasText(condition.getUserPassword())) {
            spec = spec.and(SpecificationFactory.equal(Stu_.NAME, condition.getUserPassword()));
        }
        return findAll(spec, pageable);
    }
    //fanhu
    User findByUserNameAndUserPassword(String userName,String userPassword);

}
