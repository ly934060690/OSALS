package com.zcw.mybatis.dao;

import com.zcw.mybatis.bean.Employee;

public interface EmployeeMapper {

	public Employee getEmpById(Integer id);

	public void addEmp(Employee employee);

	public void updateEmp(Employee employee);

	public void deleteEmpById(Integer id);

}
