package org.ibase4j.web.bus;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.ibase4j.core.base.BaseController;
import org.ibase4j.core.util.Request2ModelUtil;
import org.ibase4j.core.util.WebUtil;
import org.ibase4j.model.bus.BusPurchase;
import org.ibase4j.model.generator.SysMenu;

import org.ibase4j.service.bus.BusPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 采购管理
 *
 * @author zhangqinglin_cory
 * @version 2016年07月07日 下午3:14:54
 */
@RestController
@Api(value = "采购管理", description = "采购管理")
@RequestMapping(value = "prchs", method = RequestMethod.POST)
public class BusPurchaseController extends BaseController {
    @Autowired
    private BusPurchaseService busPurchaseService;

    // 查询采购
    @ApiOperation(value = "查询采购")
    @RequiresPermissions("bus.prchs.read")
    @RequestMapping(value = "/read/list")
    public Object get(HttpServletRequest request, ModelMap modelMap) {
        Map<String, Object> params = WebUtil.getParameterMap(request);
        PageInfo<?> list = busPurchaseService.query(params);
        return setSuccessModelMap(modelMap, list);
    }

    // 详细信息
    @ApiOperation(value = "采购详情")
    @RequiresPermissions("bus.prchs.read")
    @RequestMapping(value = "/read/detail")
    public Object detail(ModelMap modelMap, @RequestParam(value = "id", required = false) Integer id) {
        BusPurchase record = busPurchaseService.queryById(id);
        return setSuccessModelMap(modelMap, record);
    }

    // 新增菜单
    @ApiOperation(value = "添加采购")
    @RequiresPermissions("bus.prchs.add")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object add(HttpServletRequest request, ModelMap modelMap) {
        BusPurchase record = Request2ModelUtil.covert(BusPurchase.class, request);
        busPurchaseService.add(record);
        return setSuccessModelMap(modelMap);
    }

    // 修改菜单
    @ApiOperation(value = "修改采购")
    @RequiresPermissions("bus.prchs.updae")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Object update(HttpServletRequest request, ModelMap modelMap) {
        BusPurchase record = Request2ModelUtil.covert(BusPurchase.class, request);
        busPurchaseService.update(record);
        return setSuccessModelMap(modelMap);
    }

    // 删除菜单
    @ApiOperation(value = "删除采购")
    @RequiresPermissions("bus.prchs.delete")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Object delete(HttpServletRequest request, ModelMap modelMap,
                         @RequestParam(value = "id", required = false) Integer id) {
        busPurchaseService.delete(id);
        return setSuccessModelMap(modelMap);
    }
}
