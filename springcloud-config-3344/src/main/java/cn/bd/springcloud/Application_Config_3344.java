package cn.bd.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * config服务端集中化配置中心
 *
 */
@EnableConfigServer
@SpringBootApplication
public class Application_Config_3344
{
    public static void main( String[] args )
    {
        SpringApplication.run(Application_Config_3344.class);
    }
}
