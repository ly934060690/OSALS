package zut.base.service;

import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations = { "classpath:/applicationContextTest-resources.xml",
        "classpath:/applicationContext-dao.xml", "classpath:/applicationContext-service.xml" })
public class GenericGenerator {
}
