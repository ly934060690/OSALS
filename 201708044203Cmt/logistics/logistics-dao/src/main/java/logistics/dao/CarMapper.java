package logistics.dao;


import logistics.entity.Car;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarMapper {

    List<Car> getAllCar();
    Car getCarById(Integer id);

}
