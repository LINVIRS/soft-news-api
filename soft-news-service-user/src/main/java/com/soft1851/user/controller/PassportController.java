package com.soft1851.user.controller;

import com.soft1851.api.BaseController;
import com.soft1851.api.user.PassportControllerApi;
import com.soft1851.result.GraceResult;
import com.soft1851.utils.IpUtil;
import com.soft1851.utils.SmsUtil;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: PassportController @Description: TODO @Author: WangLinLIN @Date:
 * 2020/11/15 21:11:59  @Version: V1.0
 */
@RestController
public class PassportController  extends BaseController implements PassportControllerApi {
  @Resource private SmsUtil smsUtil;

  @Override
  public GraceResult getCode(String mobile, HttpServletRequest request) {
    //获取用户ip
    String userIp = IpUtil.getRequestIp(request);
    //根据用户的ip进行限制，限制用户60秒内只能获得一次验证码
    redis.setnx(MOBILE_SMSCODE+":"+userIp,userIp);
    // 生成随机验证码并且发送短信
    String random = (int) ((Math.random() * 9 + 1) * 100000) + "";
    smsUtil.sendSms(mobile, random);
    //把验证码存入redis 用于后续验证
    redis.set(MOBILE_SMSCODE+":"+mobile,random,30*60);
    return GraceResult.ok();
  }
}
