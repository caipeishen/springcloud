package cn.bd.springcloud.cfg;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean //boot -->spring   applicationContext.xml --- @Configuration配置   ConfigBean = applicationContext.xml
{ 
	@Bean
	@LoadBalanced // 加上才能访问服务名而且不能直接访问IP  Spring Cloud Ribbon是基于Netflix Ribbon实现的一套 客户端 负载均衡的工具。
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}

	/**
	 * 自定义Ribbon策略(默认轮询策略)
	 * @return
	 */
	@Bean
	public IRule myRule(){
		//return new RoundRobinRule()//不配置时，默认轮询
		//return new RandomRule();//随机算法
		return new RetryRule();//先按照RoundRobinRule的策略获取服务，如果获取服务失败则在指定时间内会进行重试，获取可用的服务
	}

}
