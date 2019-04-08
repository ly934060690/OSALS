package cn.com.zut;

public class SalariedEmployee extends ColaEmployee {

    private double monthlySalary;

    public SalariedEmployee(String name, int birthday, int salary, double monthlySalary) {
        super(name, birthday, salary);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public void getSalary(int month) {
        super.getSalary(month);
        super.setSalary(monthlySalary);
    }
}
