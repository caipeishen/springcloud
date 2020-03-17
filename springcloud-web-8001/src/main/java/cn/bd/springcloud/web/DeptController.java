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
public class DeptController {

    @Resource
    DeptService userService;

    @RequestMapping("/addDept")
    public Integer addDept(@RequestBody Dept dept){
        return userService.addDept(dept);
    }

    @RequestMapping("/getDeptByDno/{dno}")
    public Dept getDeptByDno(@PathVariable("dno") Integer dno){
        return userService.getDeptByDno(dno);
    }

    @RequestMapping("/getDeptList")
    public List<Dept> getDeptList(){
        return userService.getDeptList();
    }

}
