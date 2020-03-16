package com.teemo.demo.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * Swagger配置类
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Swagger 基本配置信息
     * @return Swagger配置信息对象
     */
    @Bean
    public Docket docket(Environment environment){

        //根据 Profile可以指定 Swagger文档是否展示
        Profiles profile = Profiles.of("dev");
        boolean enableFlag = environment.acceptsProfiles(profile);
        return new Docket(DocumentationType.SWAGGER_2)      //默认启用的文档类型
                .enable(enableFlag)     //是否启用 Swagger
                .apiInfo(apiInfo())     //文档描述
                .select()      //ApiSelectorBuilder 后续调用
                .apis(     //API扫描方式
//                        RequestHandlerSelectors.any()       //都扫描
//                        RequestHandlerSelectors.none()      //都不扫描
                        RequestHandlerSelectors.basePackage("com.teemo.demo.swagger.controller")       //配置基本路径,根据基本路径扫描
//                        RequestHandlerSelectors.withMethodAnnotation()       //根据方法注解扫描
//                        RequestHandlerSelectors.withClassAnnotation()       //基于类注解扫描
                )
//                .paths(PathSelectors.regex())    //正则匹配模式
                .build()        //优秀的建造者方式使用案例
                                //返回 Docket
                .groupName("teemo-01");     //分组名称
    }

    /**
     * Swagger文档描述
     */
    private ApiInfo apiInfo(){

        return new ApiInfo(
                "Swagger2 Demo",    //文档标题
                "千淘万漉虽辛苦，吹尽黄沙始到金",    //文档描述
                "1.0",    //文档版本号
                "urn:tos",    //服务组织URL
                new Contact("teemo-dana", "", "mingle_hou@sina.cn"),    //作者信息
                "Apache 2.0",    //协议
                "http://www.apache.org/licenses/LICENSE-2.0",    //协议地址
                new ArrayList<VendorExtension>());
    }

}
