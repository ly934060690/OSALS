package zut.base;

import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseAbstractTestCase extends AbstractTransactionalJUnit4SpringContextTests {
    protected Logger logger = LogManager.getLogger(BaseAbstractTestCase.class.getName());
}
