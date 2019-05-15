package atguigu.spring.aop.impl;

import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Auther: LBW
 * @Date: 2019/4/5
 * @Description: com.atguigu.spring.aop.helloworld
 * @version: 1.0
 */
@Component
public class AtithmeticCalutorImpl implements ArithmeticCalutor
{
    @Override
    public int add(int i, int j) {

        int result = i + j;

        return result;
    }

    @Override
    public int sub(int i, int j) {

        int result = i - j;

        return result;
    }

    @Override
    public int mul(int i, int j)
    {
        int result = i * j;
        return result;
    }

    @Override
    public int  div(int i, int j) {


            int result = i / j;

            return result;
    }
}
