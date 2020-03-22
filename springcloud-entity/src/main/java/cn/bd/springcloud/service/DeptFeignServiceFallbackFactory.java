package cn.bd.springcloud.service;

import cn.bd.springcloud.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 服务降级统一处理
 */
@Component  // 不要忘记添加，不要忘记添加
public class DeptFeignServiceFallbackFactory implements FallbackFactory<DeptFeignService> {

    @Override
    public DeptFeignService create(Throwable throwable) {
        return new DeptFeignService() {
            @Override
            public Dept get(Integer dno) {
                return new Dept().setDno(dno).setDname("该ID："+dno+"没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭").setDb_source("no this database in MySQL");
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }
        };
    }
}
