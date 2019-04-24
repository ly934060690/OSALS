package com.zcw.osals.osals_base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseAbstractTestCase extends AbstractTransactionalJUnit4SpringContextTests {

	protected Logger logger = LogManager.getLogger(BaseAbstractTestCase.class.getName());
}
