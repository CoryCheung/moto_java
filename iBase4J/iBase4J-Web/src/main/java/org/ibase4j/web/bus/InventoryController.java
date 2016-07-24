package org.ibase4j.web.bus;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.ibase4j.core.base.BaseController;
import org.ibase4j.core.config.Resources;
import org.ibase4j.core.support.Assert;
import org.ibase4j.core.support.login.LoginHelper;
import org.ibase4j.core.util.Request2ModelUtil;
import org.ibase4j.model.bus.BusInventory;
import org.ibase4j.model.generator.SysRole;
import org.ibase4j.model.generator.SysUser;
import org.ibase4j.service.bus.BusInventoryService;
import org.ibase4j.service.sys.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhangql on 2016/7/3.
 */
/**
 * 库存操作
 *
 * @author zhangqinglin_cory
 * @version 2016年07月03日 下午3:11:21
 */
@RestController
@Api(value = "库存接口", description = "库存接口")
@RequestMapping(value = "invntry", method = RequestMethod.POST)
public class InventoryController extends BaseController {
    @Autowired
    private BusInventoryService busInventoryService;

    // 入库
    @ApiOperation(value = "入库")
    @RequiresPermissions("bus.invntry.add")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object add(HttpServletRequest request, ModelMap modelMap) {
        BusInventory record = Request2ModelUtil.covert(BusInventory.class, request);
        busInventoryService.add(record);
        return setSuccessModelMap(modelMap);
    }
}
