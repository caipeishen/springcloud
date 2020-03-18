package cn.bd.springcloud.dao;

import cn.bd.springcloud.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface DeptMapper {

    Integer addDept(Dept dept);

    Dept getDeptByDno(Integer dno);

    List<Dept> getDeptList();
}
