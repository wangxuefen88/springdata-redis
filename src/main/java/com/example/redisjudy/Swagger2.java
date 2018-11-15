package com.example.redisjudy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
* @Description:    配置swagger2
* @Author:         王雪芬
* @CreateDate:     2018/11/15 14:51
* @UpdateUser:     王雪芬
* @UpdateDate:     2018/11/15 14:51
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@EnableSwagger2
@Configuration
public class Swagger2 {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example"))
                .paths(PathSelectors.any())
                .build();

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("User Demo")
                .description("this is judy demo")
                .version("1.0")
                .build();
    }
}
