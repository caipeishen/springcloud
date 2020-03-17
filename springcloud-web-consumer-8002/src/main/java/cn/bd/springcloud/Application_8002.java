package cn.bd.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
public class Application_8002
{
    public static void main(String[] args)
    {
        SpringApplication.run(Application_8002.class, args);
    }
}
