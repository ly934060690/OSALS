package cn.com.zut;

public class ColaEmployee {

    private String name;
    private int birthday;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary += salary;
    }

    public ColaEmployee(String name, int birthday, int salary) {
        this.name = name;
        this.birthday = birthday;
        this.salary = salary;
    }

    public void getSalary(int month) {
        if(birthday == month) {
            salary += 100;
        }
    }
}
