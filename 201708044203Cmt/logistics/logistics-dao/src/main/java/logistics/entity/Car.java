package logistics.entity;

public class Car {
    private String num;
    private float laod;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public float getLaod() {
        return laod;
    }

    public void setLaod(float laod) {
        this.laod = laod;
    }

    @Override
    public String toString() {
        return "Car{" +
                "num='" + num + '\'' +
                ", laod=" + laod +
                '}';
    }
}
