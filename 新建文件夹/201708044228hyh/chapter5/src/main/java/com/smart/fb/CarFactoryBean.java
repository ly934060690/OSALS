package com.smart.fb;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Author:
 * @Description: 编写FactoryBean一次性为Car的所有属性指定配置值
 * @Date:Created in 16:55 2019/4/29
 * @Modified By:
 */
public class CarFactoryBean implements FactoryBean<Car> {
    private String carInfo;

    public String getCarInfo() {
        return carInfo;
    }

    /**
    *@Description: -1 接收逗号分隔的属性设置信息
    *@Date: 17:04 2019/4/29
    */
    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }

    /**
    *@Description: 实例化Car Bean
    *@Date: 17:09 2019/4/29
    */
    public Car getObject() throws Exception {
        Car car=new Car();
        String[] infos=carInfo.split(",");
        car.setBrand(infos[0]);
        car.setColor(infos[1]);
        car.setMaxSpeed(Integer.parseInt(infos[2]));
        return car;
    }

    /**
    *@Description: 返回Car的类型
    *@Date: 17:14 2019/4/29
    */
    public Class<Car> getObjectType() {
        return Car.class;
    }

    /**
    *@Description: 标识通过该FactoryBean返回的Bean是singleton
    *@Date: 17:15 2019/4/29
    */
    public boolean isSingleton() {
        return false;
    }
}
