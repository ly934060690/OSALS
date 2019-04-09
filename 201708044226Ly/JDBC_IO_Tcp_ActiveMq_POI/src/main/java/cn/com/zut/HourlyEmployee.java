package cn.com.zut;

public class HourlyEmployee extends ColaEmployee {
    private double hourSalary;
    private int monthWork_Hour;

    public HourlyEmployee(String name, int birthday, int salary, double hourSalary, int monthWork_Hour) {
        super(name, birthday, salary);
        this.hourSalary = hourSalary;
        this.monthWork_Hour = monthWork_Hour;
    }

    @Override
    public void getSalary(int month) {
        super.getSalary(month);
        super.setSalary(hourSalary * monthWork_Hour);
    }
}
