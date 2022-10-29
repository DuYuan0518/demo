package com.example.demo.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.util.ObjectUtils;

@Slf4j
public class PageRequestUtil {
    public static PageRequest getRequest(PageParam page) {
        Sort sort;
        PageRequest of;

        if (page.getPage() == null || page.getPageSize() == null)
            return getDefault();
        if (!(page.getIsASC() == null)) {
            if (ObjectUtils.isEmpty(page.getProperty())) return getDefault();
            if (page.getIsASC() == true) {
                sort = Sort.by(Sort.Direction.ASC, page.getProperty());
            } else {
                // 默认是desc
                sort = Sort.by(Sort.Direction.DESC, page.getProperty());
            }
            of = PageRequest.of(page.getPage(), page.getPageSize(), sort);
        } else {
            of = PageRequest.of(page.getPage(), page.getPageSize());
        }
        return of;
    }

    public static PageRequest getDefault(Sort sort) {

        return PageRequest.of(0, 15, sort);
    }

    public static PageRequest getDefault() {

        return PageRequest.of(0, 15);
    }

    public static PageRequest getMax() {

        return PageRequest.of(0, Integer.MAX_VALUE);
    }

    public static PageRequest getLatest(String property) {
        return PageRequest.of(0, 1, Sort.Direction.DESC, property);
    }
}
