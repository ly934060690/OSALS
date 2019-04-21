package test;

import entity.Car;
import mapper.CarMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import tools.MyTools;

import java.io.IOException;

public class CarTest {

    @Test
    public void fun() throws IOException {
        /**
         * SqlSessionFactoryBuilder().build()
         * 1.构建SqlSessionFactory
         */
        //String resource = "mybatis-config.xml";
        //InputStream inputStream = Resources.getResourceAsStream(resource);
        //SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSessionFactory sqlSessionFactory = MyTools.getSqlSessionFactory();

        /**
         * openSession()方法
         * 2.从SqlSessionFactory中获取SqlSession
         */
        SqlSession session = sqlSessionFactory.openSession();
        try {
            /**
             * getMapper()方法
             * 3.通过SqlSession对象获取Mapper实例
             */
            CarMapper mapper = session.getMapper(CarMapper.class);
            /**
             * 4.调用mapper的相关方法
             */
//            Car car = mapper.getCarById(2);
            /**
             * 多参数取值#{}：
             *      1.arg0,arg1...
             *      2.param1,param2...
             *      3.@Param()注解...
             */
//            Car car = mapper.getCarByNumAndLoad("1003",2f);
//            System.out.println(car);
            Car car = new Car();
            car.setNum("1004");
            car.setId(5);
            mapper.updateById(car);
            //session.commit();
        } finally {
            /**
             * 5.关闭session
             */
            session.close();
        }

    }
    @Test
    public void fun2() throws IOException {
        SqlSessionFactory sqlSessionFactory=MyTools.getSqlSessionFactory();

        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession(true);
            CarMapper mapper= session.getMapper(CarMapper.class);
           // Car car = mapper.getCarById(5);
          //  System.out.println(car);
            //mapper.deleteCarById(5);
            mapper.insertCar(1004,3.6f);
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }
}
