package org.ibase4j.provider.bus;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.ibase4j.core.base.BaseProviderImpl;
import org.ibase4j.core.support.dubbo.spring.annotation.DubboService;
import org.ibase4j.dao.bus.expand.BusProductExpandMapper;
import org.ibase4j.dao.bus.expand.BusPurchaseExpandMapper;
import org.ibase4j.model.bus.BusProduct;
import org.ibase4j.model.bus.BusPurchase;
import org.ibase4j.model.bus.bean.BusProductBean;
import org.ibase4j.model.sys.SysUserBean;
import org.ibase4j.provider.sys.SysDicProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;

import java.util.Map;

/**
 * Created by ASUS on 2016/7/11.
 */
@CacheConfig(cacheNames = "busProduct")
@DubboService(interfaceClass = BusProductProvider.class)
public class BusProductProviderImpl extends BaseProviderImpl<BusProduct> implements BusProductProvider {
    @Autowired
    private BusProductExpandMapper busProductExpandMapper;
    @Autowired
    private SysDicProviderImpl sysDicService;

    public PageInfo<BusProductBean> queryBeans(Map<String, Object> params) {
        this.startPage(params);
        Page<Integer> productIds = busProductExpandMapper.query(params);
        Map<String, String> prdctTypeMap = sysDicService.queryDicByDicIndexKey("PRDCT_TYPE");
        PageInfo<BusProductBean> pageInfo = getPage(productIds, BusProductBean.class);
        for (BusProductBean busProductBean : pageInfo.getList()) {
            if (busProductBean.getType() != null) {
                busProductBean.setTypeText(prdctTypeMap.get(busProductBean.getType()));
            }
        }
        return pageInfo;
    }
}
