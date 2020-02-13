package cn.bd.springcloud.web;

import cn.bd.springcloud.service.UserService;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("/getUserList")
    public String getUserList(){
        return JSON.toJSONString(userService.getUserList());
    }

}
