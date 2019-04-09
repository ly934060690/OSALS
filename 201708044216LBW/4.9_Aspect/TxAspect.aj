package atguigu.AspectJ;

/**
 *@Auther: LBW
 *@Date: 2019/4/9
 *@Description: com.atguigu.AspectJ
 *@version: 1.0
 */
public aspect TxAspect
{
    void around():call(void Hello.sayhello())
            {
                System.out.println("开始事务...");
                proceed();
                System.out.println("事务结束...");
            }
}
