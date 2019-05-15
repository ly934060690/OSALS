package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 程序的耦合
 *
 *   耦合：程序间的依赖关系（独立性差）
 *         1.类之间依赖
 *         2.方法间的依赖
 *    解耦：降低程序间的依赖关系
 *
 *        实际开发中：编译期不依赖，运行期依赖
 *     解耦思路：
 *        1.使用反射创建类对象，避免使用new
 *        2.通过读取配置文件来获取要创建的对象全限定类名
 */
public class jdbcDemo {
//psvm
    public static void main(String[] args) throws Exception {

        //1.注册驱动
        //1
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //2 解耦
        //1.写死了（2.通过读取配置文件来获取要创建的对象全限定类名）
        Class.forName("com.mysql.jdbc.Driver");

        //2.获得连接
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy","root","z123");
        //3.获得操作数据库的预处理对象
        PreparedStatement pstm = conn.prepareStatement("select * from account");
        //4.执行SQL，得到结果集
        ResultSet rs = pstm.executeQuery();
        //5.遍历结果集
        while(rs.next())
        {
            System.out.println(rs.getString("name"));
        }
        //6.释放资源
        rs.close();
        pstm.close();
        conn.close();
    }
}
