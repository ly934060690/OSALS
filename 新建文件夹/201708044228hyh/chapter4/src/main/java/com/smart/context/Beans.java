package com.smart.context;

import com.smart.reflect.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

    @Bean(name="car")
    public Car buildCar(){
        Car car=new Car();
        car.setBrand("红旗CA72");
        car.setColor("黄");
        car.setMaxSpeed(200);
        return car;
    }
}
