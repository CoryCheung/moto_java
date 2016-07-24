package org.ibase4j.service.sys;

import org.ibase4j.scheduler.provider.InitBusDataProvider;
import org.ibase4j.service.init.CacheBeanPostProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ASUS on 2016/7/8.
 */
public class InitBusDataProviderImpl implements InitBusDataProvider {
    private static final Logger logger = LoggerFactory
            .getLogger(InitBusDataProviderImpl.class);
    @Override
    public void initProductData() {
        logger.debug("真的执行了这个方法。。。。");
    }
}
