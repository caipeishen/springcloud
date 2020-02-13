package cn.bd.springcloud.service.impl;

import cn.bd.springcloud.entity.User;
import cn.bd.springcloud.dao.UserMapper;
import cn.bd.springcloud.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }
}
