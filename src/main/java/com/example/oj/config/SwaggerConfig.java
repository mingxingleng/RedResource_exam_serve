package com.example.oj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.Contact;

/**
 * @author sjy
 * @date 2022/2/10
 **/
@Configuration
@EnableOpenApi
public class SwaggerConfig {
    /**
     * 创建API应用
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     * 本例采用指定扫描的包路径来定义指定要建立API的目录。
     *
     * @return
     */
//    @Bean
//    public Docket restApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("标准接口")
//                .apiInfo(apiInfo("Spring Boot中使用Swagger3构建RESTful APIs", "1.0"))
//                .useDefaultResponseMessages(true)
//                .forCodeGeneration(false)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.example.oj.controller"))
//                .paths(PathSelectors.any())
//                .build();
//    }

    @Bean
    Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.oj"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfoBuilder()
                        .description("接口文档的描述信息")
                        .title("接口文档")
                        .version("2.0")
                        .build());
    }

    /**
     * 创建该API的基本信息（这些基本信息会展现在文档页面中）
     * swagger2访问地址：http://ip:port/swagger-ui.html
     * swagger3访问地址：http://ip:port/swagger-ui/index.html
     * @return
     */
    private ApiInfo apiInfo(String title, String version) {
        return new ApiInfoBuilder()
                .title(title)
                .description("更多请关注: https://sjy-learning.blog.csdn.net")
                .termsOfServiceUrl("https://sjy-learning.blog.csdn.net")
                .contact(new Contact("xqnode", "https://sjy-learning.blog.csdn.net", "2577380101@qq.com"))
                .version(version)
                .build();
    }
}
