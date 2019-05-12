package logistics.service.impl;

import logistics.dao.CarMapper;
import logistics.entity.Car;
import logistics.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private CarMapper carMapper;

    @Autowired
    public void setCarMapper(CarMapper carMapper) {
        this.carMapper = carMapper;
    }

    @Override
    public List<Car> getAllCar()
    {
        List<Car> list = carMapper.getAllCar();
        return list;
    }

}
