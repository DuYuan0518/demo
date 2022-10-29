package com.example.demo.utils;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseDao<T, ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

    /**
     * 该接口依赖于各个jpa的底层实现，不是一个稳定接口，故废弃
     * @param id
     * @return
     * @see JpaRepository#getOne(Object)
     */
    @Deprecated
    @Override
    T getOne(ID id);

}