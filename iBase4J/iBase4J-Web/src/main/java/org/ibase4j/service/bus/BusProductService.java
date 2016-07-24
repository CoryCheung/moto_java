package org.ibase4j.service.bus;

import com.github.pagehelper.PageInfo;
import org.ibase4j.core.base.BaseService;
import org.ibase4j.core.support.dubbo.spring.annotation.DubboReference;
import org.ibase4j.model.bus.BusProduct;
import org.ibase4j.model.bus.BusPurchase;
import org.ibase4j.model.bus.bean.BusProductBean;
import org.ibase4j.model.sys.SysUserBean;
import org.ibase4j.provider.bus.BusProductProvider;
import org.ibase4j.provider.bus.BusPurchaseProvider;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by ASUS on 2016/7/11.
 */
@Service
public class BusProductService extends BaseService<BusProductProvider, BusProduct> {
    @DubboReference
    public void setProvider(BusProductProvider provider) {
        this.provider = provider;
    }

    public PageInfo<BusProductBean> queryBeans(Map<String, Object> params) {
        return provider.queryBeans(params);
    }

}
