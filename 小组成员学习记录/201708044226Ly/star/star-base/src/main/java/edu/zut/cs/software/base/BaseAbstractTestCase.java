package edu.zut.cs.software.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 * 
 * @author 研哥哥
 *
 */
public class BaseAbstractTestCase extends AbstractTransactionalJUnit4SpringContextTests {
    protected Logger logger = LogManager.getLogger(BaseAbstractTestCase.class.getName());
}
