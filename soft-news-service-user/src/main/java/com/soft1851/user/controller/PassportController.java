package com.soft1851.user.controller;

import com.soft1851.api.user.PassportControllerApi;
import com.soft1851.result.GraceResult;
import com.soft1851.utils.SmsUtil;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: PassportController @Description: TODO @Author: WangLinLIN @Date:
 * 2020/11/15 21:11:59  @Version: V1.0
 */
@RestController
public class PassportController implements PassportControllerApi {
  @Resource private SmsUtil smsUtil;

  @Override
  public GraceResult getCode(String mobile, HttpServletRequest request) {
    // 生成随机验证码并且发送短信
    String random = (int) ((Math.random() * 9 + 1) * 100000) + "";
    System.out.println(random);
    smsUtil.sendSms(mobile, random);
    return GraceResult.ok();
  }
}