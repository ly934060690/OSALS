package cn.com.zut;

public class SalesEmployee extends ColaEmployee {

    private int monthlySalesVolume; //月销售额
    private double royaltyRate;        //提成率

    public SalesEmployee(String name, int birthday, int salary, int monthlySalesVolume, double royaltyRate) {
        super(name, birthday, salary);
        this.monthlySalesVolume = monthlySalesVolume;
        this.royaltyRate = royaltyRate;
    }

    @Override
    public void getSalary(int month) {
        super.getSalary(month);
        super.setSalary(monthlySalesVolume * royaltyRate);
    }
}
