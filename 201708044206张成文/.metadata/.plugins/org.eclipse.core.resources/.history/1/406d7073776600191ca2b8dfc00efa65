package com.zcw.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.zcw.mybatis.bean.Employee;
import com.zcw.mybatis.dao.EmployeeMapper;

public class MyBatisTest {
	/**
	 * 
	 * 1.根据xml配置文件（全局配置文件）创建一个SqlSessionFactory对象
	 * 
	 * @throws IOException
	 */
	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-confing.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}

	/*
	 * @Test public void test() throws IOException { String resource =
	 * "mybatis-confing.xml"; InputStream inputStream =
	 * Resources.getResourceAsStream(resource); SqlSessionFactory
	 * sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	 * 
	 * // 获取一个sqlSession实例，能直接执行已经映射的SQL语句 SqlSession openSession =
	 * sqlSessionFactory.openSession(); try { // 1)sql的唯一标识 // 2)执行sql要用的参数
	 * Employee employee =
	 * openSession.selectOne("com.zcw.mybatis.EmployeeMapper.selectBlog", 1);
	 * 
	 * System.out.println(employee); } finally { openSession.close(); } }
	 */
	/**
	 * 
	 * SqlSession代表和数据库的一次对话，用完必须关闭
	 * SqlSeesion和connection一样都是非线程安全，每次使用都应该获取新的对象（不能定义为 private） mapper 没有实现类
	 * 但是Mabatis会为这个接口生成一个代理对象 将接口和xml文件绑定
	 * sqlSession.getMapper(EmployeeMapper.class)
	 * 
	 * 两个重要的配置文件 mybatis的全局配置文件：包含数据库连接池信息，事务管理器信息。。系统运行环境等信息
	 * ***sql映射文件：保存了每一个SQL语句的映射信息（EmployeeMapper.xml）将sql语句抽取出来
	 * 
	 * @throws Exception
	 */
	@Test
	public void test01() throws Exception {

		// 面向接口
		// 1.获取sqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		// 2.获取sqlSession对象
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			// 3获取接口的实现类对象
			// 会为接口自动创建一个代理对象，代理去执行增删改查
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);

			Employee employee = mapper.getEmpById(1);
			System.out.println(employee);
		} finally {
			openSession.close();
		}
	}

}
