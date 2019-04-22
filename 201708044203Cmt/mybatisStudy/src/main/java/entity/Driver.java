package entity;

public class Driver {
    String name;
    Integer age;
    String tel;
   Integer ageCar;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getAgeCar() {
        return ageCar;
    }

    public void setAgeCar(Integer ageCar) {
        this.ageCar = ageCar;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", tel='" + tel + '\'' +
                ", ageCar=" + ageCar +
                '}';
    }
}
