package edu.zut.cs.software.mybatis.dao;

import edu.zut.cs.software.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Select;

public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

}
