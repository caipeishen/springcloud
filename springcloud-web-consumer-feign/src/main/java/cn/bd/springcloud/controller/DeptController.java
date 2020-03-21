package cn.bd.springcloud.controller;

import cn.bd.springcloud.entity.Dept;
import cn.bd.springcloud.service.DeptFeignService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/consumer/dept")
public class DeptController
{

	@Resource
	private DeptFeignService deptFeignService;

	@RequestMapping(value = "/add")
	public boolean add(Dept dept)
	{
		return deptFeignService.add(dept);
	}

	@RequestMapping(value = "/get/{dno}")
	public Dept get(@PathVariable("dno") Integer dno)
	{
		return deptFeignService.get(dno);
	}

	@RequestMapping(value = "/list")
	public List<Dept> list()
	{
		return deptFeignService.list();
	}


}
