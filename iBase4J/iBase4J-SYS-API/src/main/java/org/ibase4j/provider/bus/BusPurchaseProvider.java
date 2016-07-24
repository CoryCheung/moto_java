package org.ibase4j.provider.bus;

import com.github.pagehelper.PageInfo;
import org.ibase4j.core.base.BaseProvider;
import org.ibase4j.model.bus.BusPurchase;
import org.ibase4j.model.generator.SysMenu;

import java.util.Map;

/**
 * 采购管理
 *
 * @author zhangqinglin_cory
 * @version 2016年07月07日 下午3:14:54
 */
public interface BusPurchaseProvider extends BaseProvider<BusPurchase> {
    PageInfo<BusPurchase> query(Map<String, Object> params);
}
