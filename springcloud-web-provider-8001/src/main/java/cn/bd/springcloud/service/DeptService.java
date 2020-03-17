package cn.bd.springcloud.service;

import java.util.List;
import cn.bd.springcloud.entity.Dept;

public interface DeptService {

    Integer addDept(Dept dept);

    Dept getDeptByDno(Integer dno);

    List<Dept> getDeptList();


}
