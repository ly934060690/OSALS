package atguigu.AspectJ;

/**
 * @Auther: LBW
 * @Date: 2019/4/9
 * @Description: com.atguigu.AspectJ
 * @version: 1.0
 */
public class Hello
{
    public void sayhello()
    {
        System.out.println("Hello,AspectJ!");
    }
    public static void main(String [] args)
    {
        Hello hello = new Hello();
        hello.sayhello();
    }
}

