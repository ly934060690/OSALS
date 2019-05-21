package entity;

public class Car {
    private Integer id;
    private String num;
    private Float loadCapacity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Float getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(Float loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", num='" + num + '\'' +
                ", loadCapacity='" + loadCapacity + '\'' +
                '}';
    }
}
