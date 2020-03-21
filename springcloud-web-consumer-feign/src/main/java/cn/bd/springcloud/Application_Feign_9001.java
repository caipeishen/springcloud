package cn.bd.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(basePackages= {"cn.bd.springcloud"})
public class Application_Feign_9001
{
    public static void main(String[] args)
    {
        SpringApplication.run(Application_Feign_9001.class, args);
    }
}
