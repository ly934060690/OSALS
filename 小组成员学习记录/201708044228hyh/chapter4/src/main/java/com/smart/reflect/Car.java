package com.smart.reflect;

public class Car {
    private String brand;
    private String color;
    private int maxSpeed;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Car(){}

    public Car(String brand,String color,int maxspeed){
        this.brand=brand;
        this.color=color;
        this.maxSpeed=maxspeed;
    }

    public void introduce(){
        System.out.println("brand:"+brand+"; color:"+color+"; maxSpeed:"+maxSpeed);
    }
}
