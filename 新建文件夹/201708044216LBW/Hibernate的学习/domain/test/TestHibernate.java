package edu.zut.cs.software.sun.admin.domain.test;

import edu.zut.cs.software.sun.admin.domain.Hibernate;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.TestExecutionListeners;

/**
 * @Auther: LBW
 * @Date: 2019/4/28
 * @Description: edu.zut.cs.software.sun.admin.domain.test
 * @version: 1.0
 */
public class TestHibernate
{
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextTest-resources.xml");
        Hibernate hibernate = null;
        {
           hibernate = (Hibernate) ctx.getBean("applicationContextTest-resources.xml");
        }

        @Test
        public void testHibernateImpl()
        {
                hibernate.FindNameByID(121);
        }


}
