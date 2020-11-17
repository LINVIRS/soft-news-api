package com.soft1851.user.controller;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.soft1851.api.user.UserControllerApi;
import com.soft1851.pojo.AppUser;
import com.soft1851.pojo.vo.UserAccountInfoVo;
import com.soft1851.result.GraceResult;
import com.soft1851.result.ResponseStatusEnum;
import com.soft1851.user.mapper.AppUserMapper;
import com.soft1851.user.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * @ClassName: UserController @Description: TODO @Author: WangLinLIN @Date:
 * 2020/11/14 19:27:53  @Version: V1.0
 */
@RestController
public class UserController implements UserControllerApi {
  @Resource private AppUserMapper appUserMapper;
  @Resource private UserService userService;

  @Override
  public Object getAllUsers() {
    return GraceResult.ok(appUserMapper.selectAll());
  }

  @Override
  public GraceResult getUserInfo(String userId) {
    if (StringUtils.isBlank(userId)) {
      return GraceResult.errorCustom(ResponseStatusEnum.UN_LOGIN);
    }
    // 根据userId 查询
    AppUser user = getUser(userId);
    // 设置需要展示信息
    UserAccountInfoVo accountInfoVo = new UserAccountInfoVo();
    // 属性拷贝
    BeanUtils.copyProperties(user, accountInfoVo);
    return GraceResult.ok(accountInfoVo);
  }

  private AppUser getUser(String userId) {
    return userService.getUser(userId);
  }
}
