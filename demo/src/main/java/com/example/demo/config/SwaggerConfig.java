package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30).apiInfo(
                new ApiInfoBuilder()
                            .contact(new Contact("杜源", "", "duyuan@qq.com"))
                            .title("编程能力提升的后台文档")
                            .description("编程能力提升的后台文档")
                            .version("1.0")
                            .build())
                    // 是否开启
                    .select()
                    // 扫描的路径包
                    // 指定路径处理PathSelectors.any()代表所有的路径
                    .paths(PathSelectors.any()).build();
    }
}
