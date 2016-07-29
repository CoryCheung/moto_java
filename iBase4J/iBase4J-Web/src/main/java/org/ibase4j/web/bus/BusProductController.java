package org.ibase4j.web.bus;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.ibase4j.core.base.BaseController;
import org.ibase4j.core.util.Request2ModelUtil;
import org.ibase4j.core.util.WebUtil;
import org.ibase4j.model.bus.BusProduct;
import org.ibase4j.model.bus.BusPurchase;
import org.ibase4j.service.bus.BusProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by ASUS on 2016/7/11.
 */
@RestController
@Api(value = "商品信息管理", description = "商品信息管理")
@RequestMapping(value = "prdct", method = RequestMethod.POST)
public class BusProductController extends BaseController {
    @Autowired
    private BusProductService busProductService;

    // 查询商品信息
    @ApiOperation(value = "查询商品信息")
    @RequiresPermissions("bus.prdct.read")
    @RequestMapping(value = "/read/list")
    public Object get(HttpServletRequest request, ModelMap modelMap) {
        Map<String, Object> params = WebUtil.getParameterMap(request);
        PageInfo<?> list = busProductService.queryBeans(params);
        return setSuccessModelMap(modelMap, list);
    }

    // 详细信息
    @ApiOperation(value = "商品信息详情")
    @RequiresPermissions("bus.prdct.read")
    @RequestMapping(value = "/read/detail")
    public Object detail(ModelMap modelMap, @RequestParam(value = "id", required = false) Integer id) {
        BusProduct record = busProductService.queryById(id);
        return setSuccessModelMap(modelMap, record);
    }

    // 新增商品信息
    @ApiOperation(value = "新增商品信息")
    @RequiresPermissions("bus.prdct.add")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object add(HttpServletRequest request, ModelMap modelMap) {
        BusProduct record = Request2ModelUtil.covert(BusProduct.class, request);
        busProductService.add(record);
        return setSuccessModelMap(modelMap);
    }

    // 修改商品信息
    @ApiOperation(value = "修改商品信息")
    @RequiresPermissions("bus.prdct.update")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Object update(HttpServletRequest request, ModelMap modelMap) {
        BusProduct record = Request2ModelUtil.covert(BusProduct.class, request);
        busProductService.update(record);
        return setSuccessModelMap(modelMap);
    }

    // 删除商品信息
    @ApiOperation(value = "删除商品信息")
    @RequiresPermissions("bus.prdct.delete")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Object delete(HttpServletRequest request, ModelMap modelMap,
                         @RequestParam(value = "id", required = false) Integer id) {
        busProductService.delete(id);
        return setSuccessModelMap(modelMap);
    }
}
