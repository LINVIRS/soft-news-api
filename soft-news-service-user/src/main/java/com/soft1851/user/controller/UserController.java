package com.soft1851.user.controller;

import com.soft1851.api.user.UserControllerApi;
import com.soft1851.pojo.AppUser;
import com.soft1851.result.GraceResult;
import com.soft1851.user.mapper.AppUserMapper;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/11/14 19:27:53 
 * @Version: V1.0
 **/
@RestController
public class UserController implements UserControllerApi {
    @Resource
    private AppUserMapper appUserMapper;

    @Override
    public Object getAllUsers() {
        return GraceResult.ok(appUserMapper.selectAll());
    }

    @Override
    public GraceResult getUserInfo(String userId) {
        Example userExample =new Example(AppUser.class);
        Example.Criteria userCriteria=userExample.createCriteria();
        userCriteria.andEqualTo("id",userId);
        AppUser user =appUserMapper.selectByPrimaryKey(userExample);
        return GraceResult.ok(user);
    }
}
