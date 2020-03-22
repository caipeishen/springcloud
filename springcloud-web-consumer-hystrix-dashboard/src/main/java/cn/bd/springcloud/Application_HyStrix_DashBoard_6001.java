package cn.bd.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class Application_HyStrix_DashBoard_6001
{
    public static void main(String[] args)
    {
        SpringApplication.run(Application_HyStrix_DashBoard_6001.class, args);
    }
}
