package com.soft1851.api.user;

import com.soft1851.result.GraceResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.bouncycastle.crypto.modes.gcm.GCMExponentiator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

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
}
