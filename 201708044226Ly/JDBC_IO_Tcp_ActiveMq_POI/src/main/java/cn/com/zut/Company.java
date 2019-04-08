package cn.com.zut;

public class Company {
    public void toString(ColaEmployee[] colaEmployee) {
        for(int i = 0; i < colaEmployee.length; i++) {
            colaEmployee[i].getSalary(i + 1);
            System.out.println("员工姓名：" + colaEmployee[i].getName() + "\t" +
                    "本月收入：" + colaEmployee[i].getSalary());
        }
    }
}
