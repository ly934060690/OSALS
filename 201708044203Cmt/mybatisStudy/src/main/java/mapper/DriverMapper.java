package mapper;

import entity.Driver;
import org.apache.ibatis.annotations.Param;

public interface DriverMapper {

    Driver getDriverById(Integer id);
    Driver getDriverByNameAndAge(@Param("NAME") String name, @Param("AGE") Integer age);
    void insertDriver(Driver driver);
    void updateDriver();
}
