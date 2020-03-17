package cn.bd.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient //服务注册到Eureaka
@EnableDiscoveryClient //服务发现Eureaka
@MapperScan("cn.bd.springcloud.dao")
@SpringBootApplication
public class Application_8001{

    public static void main(String[] args) {
        SpringApplication.run(Application_8001.class, args);
    }

}

