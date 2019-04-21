package test;

import entity.Driver;
import mapper.DriverMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import tools.MyTools;

import java.io.IOException;

public class DriverTest {

    @Test
    public  void  test () throws IOException
    {
            SqlSessionFactory sqlSessionFactory= MyTools.getSqlSessionFactory();
        SqlSession session=null;
        try{
            session=sqlSessionFactory.openSession(true);
            DriverMapper mapper=session.getMapper(DriverMapper.class);
//            Driver driver=mapper.getDriverById(2);
//            System.out.println(driver);
            Driver driver=mapper.getDriverByNameAndAge("张三",36);
            System.out.println(driver);
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
