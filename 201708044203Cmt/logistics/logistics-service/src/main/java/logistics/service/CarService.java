package logistics.service;

import logistics.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> getAllCar();
    Car getCarById(Integer id);
    Integer saveOne(Car car);
    Integer updateById(Car car);
    Integer deleteById(Integer id);
}
