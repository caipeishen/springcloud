package cn.bd.springcloud.service.impl;

import cn.bd.springcloud.dao.DeptMapper;
import cn.bd.springcloud.entity.Dept;
import cn.bd.springcloud.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Resource
    private DeptMapper deptMapper;

    @Override
    public Integer addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public Dept getDeptByDno(Integer dno) {
        return deptMapper.getDeptByDno(dno);
    }

    @Override
    public List<Dept> getDeptList() {
        return deptMapper.getDeptList();
    }

}
