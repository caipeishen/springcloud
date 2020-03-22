package cn.bd.springcloud.web;

import cn.bd.springcloud.entity.Dept;
import cn.bd.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/dept")
public class DeptController {

    @Resource
    DeptService userService;


    @RequestMapping("/list")
    public List<Dept> getDeptList(){
        return userService.getDeptList();
    }


    @RequestMapping("/get/{dno}")
    //一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    @HystrixCommand(fallbackMethod="fallbackGetDeptByDno")
    public Dept getDeptByDno(@PathVariable("dno") Integer dno) {
        Dept dept = userService.getDeptByDno(dno);
        if(dept == null){
            throw new RuntimeException("该ID："+dno+"不存在数据库中!");
        }
        return dept;
    }

    /**
     * getDeptByDno方法 熔断器的fallback方法
     * @param dno
     * @return
     */
    public Dept fallbackGetDeptByDno(@PathVariable("dno") Integer dno){
        return new Dept().setDno(dno).setDname("该ID："+dno+"没有对应的信息,null--@HystrixCommand").setDb_source("no this database in MySQL");
    }

}
