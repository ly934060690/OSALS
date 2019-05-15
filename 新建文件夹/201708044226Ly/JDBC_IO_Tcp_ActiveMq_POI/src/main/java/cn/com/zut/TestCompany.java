package cn.com.zut;

public class TestCompany {
    public static void main(String[] args) {

        ColaEmployee[] colaEmployee = new ColaEmployee[3];
        colaEmployee[0] = new SalariedEmployee("Ly1", 1, 0, 3000);
        colaEmployee[1] = new HourlyEmployee("Ly2", 2, 0, 300, 200);
        colaEmployee[2] = new SalesEmployee("Ly3", 3, 0, 50000, 0.1);

        new Company().toString(colaEmployee);



    }
}
