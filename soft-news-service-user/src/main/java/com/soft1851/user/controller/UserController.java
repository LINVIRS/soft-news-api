package com.soft1851.user.controller;

import com.soft1851.api.user.UserControllerApi;
import com.soft1851.result.GraceResult;
import com.soft1851.user.mapper.AppUserMapper;
import org.springframework.web.bind.annotation.RestController;

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
    public Object getUsers() {
        return GraceResult.ok(appUserMapper.selectAll());
    }
}
