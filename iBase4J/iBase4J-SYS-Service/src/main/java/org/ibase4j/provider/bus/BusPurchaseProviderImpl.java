package org.ibase4j.provider.bus;

import com.github.pagehelper.PageInfo;
import org.ibase4j.core.base.BaseProviderImpl;
import org.ibase4j.core.support.dubbo.spring.annotation.DubboService;
import org.ibase4j.dao.bus.expand.BusPurchaseExpandMapper;
import org.ibase4j.model.bus.BusPurchase;
import org.ibase4j.provider.sys.SysDicProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;

import java.util.Map;

/**
 * @author ShenHuaJie
 * @version 2016年5月20日 下午3:19:19
 */
@DubboService(interfaceClass = BusPurchaseProvider.class)
@CacheConfig(cacheNames = "busPurchase")
public class BusPurchaseProviderImpl extends BaseProviderImpl<BusPurchase> implements BusPurchaseProvider {
    @Autowired
    private BusPurchaseExpandMapper busPurchaseExpandMapper;
    @Autowired
    private SysDicProviderImpl sysDicService;

    public PageInfo<BusPurchase> query(Map<String, Object> params) {
        this.startPage(params);
        PageInfo<BusPurchase> pageInfo = getPage(busPurchaseExpandMapper.query(params));
        Map<String, String> menuTypeMap = sysDicService.queryDicByDicIndexKey("MENUTYPE");
        for (BusPurchase busPurchase : pageInfo.getList()) {
//			if (busPurchase.getMenuType() != null) {
//				busPurchase.setRemark(menuTypeMap.get(busPurchase.getMenuType().toString()));
//			}
        }
        return pageInfo;
    }

}
