package cn.bd.springcloud.web;

import cn.bd.springcloud.entity.Dept;
import cn.bd.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/dept")
public class DeptController {

    @Resource
    DeptService userService;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/add")
    public Integer addDept(Dept dept){
        return userService.addDept(dept);
    }

    @RequestMapping("/get/{dno}")
    public Dept getDeptByDno(@PathVariable("dno") Integer dno){
        return userService.getDeptByDno(dno);
    }

    @RequestMapping("/list")
    public List<Dept> getDeptList(){
        return userService.getDeptList();
    }

    /**
     * 服务发现
     * @return
     */
    @RequestMapping(value = "/discovery", method = RequestMethod.GET)
    public Object discovery()
    {
        List<String> list = client.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }

}
