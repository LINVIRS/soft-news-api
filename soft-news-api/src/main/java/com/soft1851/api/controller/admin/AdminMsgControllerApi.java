package com.soft1851.api.controller.admin;

import com.soft1851.pojo.bo.AdminLoginBO;
import com.soft1851.pojo.bo.NewAdminBO;
import com.soft1851.result.GraceResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: ads
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/11/21 15:06:19 
 * @Version: V1.0
 **/
@Api(value = "管理员维护",tags = {"管理员维护controller"})
@RequestMapping("adminMsg")
public interface AdminMsgControllerApi {
    /**
     * 管理员登录
     * @param adminLoginBO
     * @param request
     * @param response
     * @return
     */
    @PostMapping("adminLogin")
    @ApiOperation(value = "管理员登录",notes = "管理员登录",httpMethod = "POST")
    GraceResult adminLogin(@RequestBody AdminLoginBO adminLoginBO,
                           HttpServletRequest request,
                           HttpServletResponse response);

    /**
     * 查询管理员是否存在
     * @param username
     * @return
     */
    @PostMapping("adminIsExist")
    @ApiOperation(value = "查询管理员是否存在",notes = "查询管理人员是否存在",httpMethod = "POST")
    GraceResult adminIsExist(@RequestParam String username);

    /**
     * 新增管理员
     * @param request
     * @param response
     * @param newAdminBO
     * @return
     */
    @PostMapping("addNewAdmin")
    @ApiOperation(value = "添加新的管理人员",notes = "添加新的管理人员",httpMethod = "POST")
    GraceResult addNewAdmin(HttpServletRequest request, HttpServletResponse response, @RequestBody NewAdminBO newAdminBO);

}
