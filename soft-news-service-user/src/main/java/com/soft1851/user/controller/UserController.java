package com.soft1851.user.controller;

import com.soft1851.api.BaseController;
import com.soft1851.api.controller.user.UserControllerApi;
import com.soft1851.pojo.AppUser;
import com.soft1851.pojo.bo.UpdateUserInfoBO;
import com.soft1851.pojo.vo.AppUserVO;
import com.soft1851.pojo.vo.UserAccountInfoVo;
import com.soft1851.result.GraceResult;
import com.soft1851.result.ResponseStatusEnum;
import com.soft1851.user.mapper.AppUserMapper;
import com.soft1851.user.service.UserService;
import com.soft1851.utils.JsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: UserController @Description: TODO @Author: WangLinLIN @Date:
 * 2020/11/14 19:27:53  @Version: V1.0
 */
@RestController
public class UserController extends BaseController implements UserControllerApi {
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

  @Override

  public GraceResult updateUserInfo(UpdateUserInfoBO updateUserInfoBO, BindingResult result) {
    // 判断bindResult 是否保存验证信息 如果有直接return
    if (result.hasErrors()) {
      Map<String, String> errorMap = getErrors(result);
      return GraceResult.errorMap(errorMap);
    }
    userService.updateUserInfo(updateUserInfoBO);
    return GraceResult.ok();
  }

  @Override
  public GraceResult getUserBasicInfo(String userId) {
    // 判断不能为空
    if (StringUtils.isBlank(userId)) {
      return GraceResult.errorCustom(ResponseStatusEnum.UN_LOGIN);
    }
    // 查询用户id
    AppUser user = getUser(userId);
    // 信息脱敏
    AppUserVO appUserVO = new AppUserVO();
    BeanUtils.copyProperties(user, appUserVO);
    return GraceResult.ok(appUserVO);
  }
  @Override
  public GraceResult queryByIds(String userIds) {
    if (StringUtils.isBlank(userIds)){
      return GraceResult.errorCustom(ResponseStatusEnum.USER_NOT_EXIST_ERROR);
    }
    List<AppUserVO> publishList = new ArrayList<>();
    List<String> userIdList = JsonUtil.jsonToList(userIds,String.class);
    assert  userIdList != null;
    for (String userId: userIdList
    ) {
      //获得用户基本信息
      AppUserVO userVO = getBasicUserInfo(userId);
      //添加到publishList中
      publishList.add(userVO);
    }
    return GraceResult.ok(publishList);
  }
  private AppUserVO getBasicUserInfo(String userId){
    //1,根据userId查询用户信息
    AppUser user = getUser(userId);
    //返回用户信息
    AppUserVO userVO = new AppUserVO();
    BeanUtils.copyProperties(user,userVO);
    return userVO;
  }
  private AppUser getUser(String userId) {
    String userJson = redis.get(REDIS_USER_INFO + ":" + userId);
    AppUser user;
    if (StringUtils.isNotBlank(userJson)) {
      user = JsonUtil.jsonToPojo(userJson, AppUser.class);
    } else {
      user = userService.getUser(userId);
      redis.set(REDIS_USER_INFO + ":" + userId, JsonUtil.objectToJson(user), 1);
    }
    return user;
  }
}
