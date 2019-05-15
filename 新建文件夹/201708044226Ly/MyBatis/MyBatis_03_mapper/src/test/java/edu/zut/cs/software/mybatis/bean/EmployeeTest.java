package edu.zut.cs.software.mybatis.bean;

import edu.zut.cs.software.mybatis.bean.Employee;
import edu.zut.cs.software.mybatis.dao.EmployeeMapper;
import edu.zut.cs.software.mybatis.dao.EmployeeMapperAnnotation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class EmployeeTest {

    public SqlSessionFactory getSqlSessionFactory() {
        String resource = "mybatis-config.xml";

        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test() {

        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            Employee employee = sqlSession.selectOne("edu.zut.cs.software.mybatis.EmployeeMapper.selectEmp", 1);
            System.out.println(employee);
        } finally {
            sqlSession.close();
        }


    }

    @Test
    public void test01() {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee empById = mapper.getEmpById(1);
            System.out.println(mapper.getClass());
            System.out.println(empById);
        } finally {
            sqlSession.close();
        }

    }

    @Test
    public  void test02() {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperAnnotation mapper = sqlSession.getMapper(EmployeeMapperAnnotation.class);
            Employee empById = mapper.getEmpById(1);
            System.out.println(empById);
        }finally {
            sqlSession.close();
        }
    }

    /**
     * 测试增删改
     */
    @Test
    public void test03() {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //无参，不自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            //测试添加
            Employee employee = new Employee(null, "ly", "1", "ly@ygg.com");
            Long addEmp = mapper.addEmp(employee);
            System.out.println(employee.getId());
            System.out.println(addEmp);
            //测试修改
//            Employee employee = new Employee(1, "ly", "1", "ly@ygg.com");
//            boolean updateEmp = mapper.updateEmp(employee);
//            System.out.println(updateEmp);
            //测试删除
//            mapper.deleteEmpById(2);
            //手动提交
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test04() {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //无参，不自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.getEmpByIdAndLastName(1, "ly");
            System.out.println(employee);
        } finally {
            sqlSession.close();
        }
    }

}