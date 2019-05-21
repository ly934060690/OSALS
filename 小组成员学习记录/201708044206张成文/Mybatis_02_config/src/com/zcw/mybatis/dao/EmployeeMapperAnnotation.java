package com.zcw.mybatis.dao;

import org.apache.ibatis.annotations.Select;

import com.zcw.mybatis.bean.Employee;

public interface EmployeeMapperAnnotation {

	@Select("select *from account where id=#{id}")
	public Employee getEmpById(Integer id);
}
