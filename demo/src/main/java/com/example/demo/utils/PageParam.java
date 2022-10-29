package com.example.demo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageParam {

    private Integer page;

    private Integer pageSize;

    private String property;

    private Boolean isASC;
}
