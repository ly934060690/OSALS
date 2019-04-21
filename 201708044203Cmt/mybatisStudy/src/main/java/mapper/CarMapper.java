package mapper;

import entity.Car;
import org.apache.ibatis.annotations.Param;

public interface CarMapper {

    Car getCarById(Integer id);

    Car getCarByNumAndLoad(@Param("NUM") String num,@Param("LOAD") Float load);

    void updateById(@Param("car") Car car);
     void deleteCarById(Integer id);
     void insertCar(@Param("NUM") int num,@Param("LOAD") float load);
}
