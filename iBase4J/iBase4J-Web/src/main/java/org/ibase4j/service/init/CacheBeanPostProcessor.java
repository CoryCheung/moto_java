package org.ibase4j.service.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CacheBeanPostProcessor implements BeanPostProcessor {

    private static final Logger logger = LoggerFactory
            .getLogger(CacheBeanPostProcessor.class);

    @Override
    public Object postProcessAfterInitialization(Object obj, String arg1)
            throws BeansException {
        try {
//			if (obj instanceof FundCacheService) {
//				logger.info("开始初始化加载缓存信息--FundCacheService");
//				((FundCacheService) obj).process(null);
//				logger.info("完成初始化加载缓存信息--FundCacheService");
//			}

        } catch (Exception e) {
            logger.error("初始化加载缓存信息报错");
            logger.error(e.getMessage(), e);
        }
        return obj;
    }

    @Override
    public Object postProcessBeforeInitialization(Object arg0, String arg1)
            throws BeansException {
        return arg0;
    }

}