package logistics.entity;

public class Car {
    private Integer id;
    private String num;
    private float laod;

    public String getNum() {
        return num;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
                "id=" + id +
                ", num='" + num + '\'' +
                ", laod=" + laod +
                '}';
    }
}
