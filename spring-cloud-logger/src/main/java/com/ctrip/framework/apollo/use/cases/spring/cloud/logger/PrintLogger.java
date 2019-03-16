package com.ctrip.framework.apollo.use.cases.spring.cloud.logger;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by kl on 2018/6/25.
 * Content :
 */
@Service
public class PrintLogger {
    private static Logger logger = LoggerFactory.getLogger(PrintLogger.class);

    @Value("${eureka.client.serviceUrl.defaultZone}")
    private String logEvel;

    private String test1;

    @PostConstruct
    public void printLogger() throws Exception{
        Executors.newSingleThreadExecutor().submit(() -> {
            while (true) {
                logger.info("我是info级别日志");
                logger.error("我是error级别日志");
                logger.warn("我是warn级别日志"+logEvel+"11"+test1);
                logger.debug("我是debug级别日志");

                TimeUnit.SECONDS.sleep(3);
            }
        });
    }

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }
}
