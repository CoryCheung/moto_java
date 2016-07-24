package org.ibase4j.provider.bus;

import com.github.pagehelper.PageInfo;
import org.ibase4j.core.base.BaseProvider;
import org.ibase4j.model.bus.BusProduct;
import org.ibase4j.model.bus.bean.BusProductBean;

import java.util.Map;

/**
 * Created by ASUS on 2016/7/11.
 */
public interface BusProductProvider extends BaseProvider<BusProduct> {
    PageInfo<BusProductBean> queryBeans(Map<String, Object> params);
}
