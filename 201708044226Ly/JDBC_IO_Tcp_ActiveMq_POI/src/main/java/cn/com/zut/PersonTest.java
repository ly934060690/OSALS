package cn.com.zut;

public class PersonTest {
    public static void main(String []args) {
        Person []P = new Person[5];
        for(int i = 0; i < 5; i++) {
            P[i] = new Person("xiaolaji", "nv");
        }

        for(int i = 0; i < 5; i++) {
            System.out.println(P[i].toString());
        }
        System.out.println(P.length);
    }
}
