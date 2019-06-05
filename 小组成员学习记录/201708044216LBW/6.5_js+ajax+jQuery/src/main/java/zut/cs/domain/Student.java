package zut.cs.domain;

import java.io.Serializable;

/**
 * @Auther: LBW
 * @Date: 2019/5/29
 * @Description: zut.cs.domain
 * @version: 1.0
 */
public class Student implements Serializable {

    public String Name;

    public String Numbers;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNumbers() {
        return Numbers;
    }

    public void setNumbers(String numbers) {
        Numbers = numbers;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Name='" + Name + '\'' +
                ", Numbers='" + Numbers + '\'' +
                '}';
    }
}
