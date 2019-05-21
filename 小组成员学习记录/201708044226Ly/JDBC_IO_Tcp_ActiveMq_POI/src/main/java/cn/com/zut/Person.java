package cn.com.zut;

public class Person {
    private String name;
    private String sex;

    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public static void main(String []args) {
        Person father = new Person("Father", "Nan");
        Person mother = new Person("Mother", "Nv");
        Person me = new Person("Xiaolaji", "Nv");
        Person brother = new Person("Brother", "Nan");
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(me.toString());
        System.out.println(brother.toString());
        me.setName("LiangYing");
        System.out.println(me.getName());
        System.out.println(me.getSex());


    }
}
