package edu.zut.cs.software;

import java.sql.*;

/**
 * 程序的耦合
 *      耦合：程序间的依赖关系
 *          包括：
 *              类之间的依赖
 *              方法间的依赖
 *      解耦：降低程序间的依赖关系
 *          实际开发中：
 *              应该做到：编译期不依赖，运行时才依赖
 *      解决思路：
 *          1、使用反射来创建对象，而避免使用new关键字
 *          2、通过读取配置文件来获取要创建的对象全限定类名
 */
public class jdbc {
    public static void main(String []args) throws SQLException, ClassNotFoundException {
        //1、注册驱动
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.jdbc.Driver");
        //2、获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
        //3、获取操作数据库的预处理对象
        PreparedStatement preparedStatement = connection.prepareStatement("select * from students");
        //4、执行SQL,得到结果集
        ResultSet resultSet = preparedStatement.executeQuery();
        //5、遍历结果集
        int numColumns = resultSet.getMetaData().getColumnCount();
        while (resultSet.next()) {
            for(int i = 1; i <= numColumns; i++) {
                System.out.print(resultSet.getString(i) + '\t');
            }
            System.out.println();
        }
        //6、释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
