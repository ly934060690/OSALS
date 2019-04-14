package edu.zut.cs.software.mybatis.dao;

import edu.zut.cs.software.mybatis.bean.Employee;

public interface EmployeeMapper {

    public Employee getEmpById(Integer id);
}
