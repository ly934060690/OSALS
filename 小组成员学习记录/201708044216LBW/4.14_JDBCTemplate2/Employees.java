package com.atguigu.spring.jdbc;

/**
 * @Auther: LBW
 * @Date: 2019/4/14
 * @Description: com.atguigu.spring.jdbc
 * @version: 1.0
 */
public class Employees
{
    private Integer ID;
    private String LAST_NAME;
    private String EMAIL;
    private Integer DEPT_ID;

    private Department department;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public void setLAST_NAME(String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public Integer getDEPT_ID() {
        return DEPT_ID;
    }

    public void setDEPT_ID(Integer DEPT_ID) {
        this.DEPT_ID = DEPT_ID;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "ID=" + ID +
                ", LAST_NAME='" + LAST_NAME + '\'' +
                ", EMAIL='" + EMAIL + '\'' +
                ", DEPT_ID=" + DEPT_ID +
                ", department=" + department +
                '}';
    }
}
