package cn.bd.springcloud.service;

import cn.bd.springcloud.entity.Dept;

import java.util.List;

public interface DeptService {

    Integer addDept(Dept dept);

    Dept getDeptByDno(Integer dno);

    List<Dept> getDeptList();


}
