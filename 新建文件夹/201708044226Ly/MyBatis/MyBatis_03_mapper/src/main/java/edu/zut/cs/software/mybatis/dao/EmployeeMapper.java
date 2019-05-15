package edu.zut.cs.software.mybatis.dao;

import edu.zut.cs.software.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {

    public Employee getEmpById(Integer id);
    public Employee getEmpByIdAndLastName(@Param("id") Integer id, @Param("lastName") String lastName);

    public Long addEmp(Employee employee);

    public boolean updateEmp(Employee employee);

    public void deleteEmpById(Integer id);

}
