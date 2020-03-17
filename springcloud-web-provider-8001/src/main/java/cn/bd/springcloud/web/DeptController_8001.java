package cn.bd.springcloud.web;

import cn.bd.springcloud.entity.Dept;
import cn.bd.springcloud.service.DeptService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/dept")
public class DeptController_8001 {

    @Resource
    DeptService userService;

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

}
