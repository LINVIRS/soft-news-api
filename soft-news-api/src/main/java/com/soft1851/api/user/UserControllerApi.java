package com.soft1851.api.user;

import com.soft1851.pojo.bo.UpdateUserInfoBO;
import com.soft1851.result.GraceResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;

/**
 * @ClassName: UserControllerApi @Description: TODO @Author: WangLinLIN @Date:
 * 2020/11/14 19:23:44  @Version: V1.0
 */
@Api(
    value = "用户信息相关Controller",
    tags = {"用户信息相关Controller"})
@RequestMapping("user")
public interface UserControllerApi {
  /**
   * 获取所有用户
   *
   * @return
   */
  @ApiOperation(value = "获得所有用户信息", notes = "获得所有用户信息", httpMethod = "POST")
  @PostMapping("/users")
  Object getAllUsers();

  /**
   * 获取用户基本信息
   *
   * @param userId
   * @return
   */
  @ApiOperation(value = "获得用户基本信息", notes = "获得用户基本信息", httpMethod = "POST")
  @PostMapping("/userInfo")
  GraceResult getUserInfo(@RequestParam String userId);

  /**
   * 更新用户信息
   *
   * @param updateUserInfoBO
   * @param result
   * @return
   */
  @PostMapping("/updateUserInfo")
  @ApiOperation(value = "完善用户信息", notes = "完善用户信息", httpMethod = "POST")
  GraceResult updateUserInfo(
      @RequestBody @Validated UpdateUserInfoBO updateUserInfoBO, BindingResult result);

  /**
   * 获得用户基础信息
   * @param userId
   * @return
   */
  @PostMapping("/userBasicInfo")
  @ApiOperation(value = "获得用户基础信息", notes = "获得用户基础信息", httpMethod = "POST")
  GraceResult getUserBasicInfo(@RequestParam String userId);
}
