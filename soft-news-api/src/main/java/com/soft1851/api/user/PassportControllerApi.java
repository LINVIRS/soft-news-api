package com.soft1851.api.user;

import com.soft1851.pojo.bo.RegistLoginBO;
import com.soft1851.result.GraceResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.bouncycastle.crypto.modes.gcm.GCMExponentiator;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @ClassName: PassportController @Description: TODO @Author: WangLinLIN @Date:
 * 2020/11/15 21:08:51  @Version: V1.0
 */
@Api(
    value = "用户注册登录",
    tags = {"用户注册登录Controller"})
@RequestMapping("passport")
public interface PassportControllerApi {
  @ApiOperation(value = "获得短信验证码", notes = "获得短信验证码", httpMethod = "GET")
  @GetMapping("/smsCode")
  GraceResult getCode(@RequestParam String mobile, HttpServletRequest request);

  /**
   * 一键注册登录接口
   *
   * @param registLoginBO
   * @param result
   * @param request
   * @param response
   * @return
   */
  @ApiOperation(value = "一键注册登录接口", notes = "一键注册登录接口", httpMethod = "POST")
  @PostMapping("/sign")
  GraceResult doSign(
      @RequestBody @Valid RegistLoginBO registLoginBO,
      BindingResult result,
      HttpServletRequest request,
      HttpServletResponse response);
}
