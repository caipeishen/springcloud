package cn.bd.springcloud;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 路由网关
 *
 */
@EnableZuulProxy
@SpringBootConfiguration
@EnableAutoConfiguration
public class Application_Zuul_Gateway_9527
{
    public static void main( String[] args )
    {
        SpringApplication.run(Application_Zuul_Gateway_9527.class);
    }
}
