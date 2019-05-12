package logistics.entity;

public class Car {
    private Integer id;
    private String carNum;
    private float carLoad;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public float getCarLoad() {
        return carLoad;
    }

    public void setCarLoad(float carLoad) {
        this.carLoad = carLoad;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carNum='" + carNum + '\'' +
                ", carLoad=" + carLoad +
                '}';
    }
}
