package com.example.demo.dao;

import com.example.demo.dto.QueryStuCondition;
import com.example.demo.entity.Stu;

import com.example.demo.entity.Stu_;
import com.example.demo.entity.User;
import com.example.demo.utils.BaseDao;
import com.example.demo.utils.SpecificationFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public interface StuDao extends BaseDao<Stu, Long> {

    default Page<Stu> page(Pageable pageable, QueryStuCondition condition) {
        Specification<Stu> spec = SpecificationFactory.builder();
        if (condition.getKey() != null && StringUtils.hasText(condition.getKey())) {
            String c = "%" + condition.getKey() + "%";
            Specification<Stu> orSpec = SpecificationFactory.like(Stu_.KEY, c);
            spec = spec.and(orSpec);
        }
        if (condition.getName() != null && StringUtils.hasText(condition.getName())) {
            spec = spec.and(SpecificationFactory.equal(Stu_.NAME, condition.getName()));
        }
        return findAll(spec, pageable);
    }


}
