package org.ibase4j.service.bus;

import org.ibase4j.core.base.BaseService;
import org.ibase4j.core.support.dubbo.spring.annotation.DubboReference;
import org.ibase4j.model.bus.BusPurchase;
import org.ibase4j.provider.bus.BusPurchaseProvider;
import org.springframework.stereotype.Service;

/**
 * 采购管理
 *
 * @author zhangqinglin_cory
 * @version 2016年07月07日 下午3:14:54
 */
@Service
public class BusPurchaseService extends BaseService<BusPurchaseProvider, BusPurchase> {
    @DubboReference
    public void setProvider(BusPurchaseProvider provider) {
        this.provider = provider;
    }
}
