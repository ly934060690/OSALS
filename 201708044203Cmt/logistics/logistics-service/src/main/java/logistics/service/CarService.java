package logistics.service;

import logistics.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> getAllCar();
    Car getCarById(Integer id);
}
