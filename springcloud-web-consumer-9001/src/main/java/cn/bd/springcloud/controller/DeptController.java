package cn.bd.springcloud.controller;

import cn.bd.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer/dept")
public class DeptController
{

	//restTemplate 加上@LoadBalanced注解 将不能直接访问IP 只能访问服务名
	//private static final String REST_URL_PREFIX = "http://localhost:8001";

	//通过微服务名访问，从这里还是真正的微服务 restTemplate 加上@LoadBalanced 注解才可以访问服务名
	private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-WEB";

	/**
	 * 使用 使用restTemplate访问restful接口非常的简单粗暴无脑。 (url, requestMap,
	 * ResponseBean.class)这三个参数分别代表 REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
	 */
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/add")
	public boolean add(Dept dept)
	{
		return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
	}

	@RequestMapping(value = "/get/{dno}")
	public Dept get(@PathVariable("dno") Integer dno)
	{
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + dno, Dept.class);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/list")
	public List<Dept> list()
	{
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
	}

	// 测试@EnableDiscoveryClient,消费端可以调用服务发现
	@RequestMapping(value = "/discovery")
	public Object discovery()
	{
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
	}

}
