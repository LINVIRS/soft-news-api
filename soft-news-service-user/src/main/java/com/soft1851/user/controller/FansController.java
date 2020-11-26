package com.soft1851.user.controller;

import com.soft1851.api.BaseController;
import com.soft1851.api.controller.user.FansControllerApi;
import com.soft1851.pojo.AppUser;
import com.soft1851.result.GraceResult;
import com.soft1851.result.ResponseStatusEnum;
import com.soft1851.user.service.FansService;
import com.soft1851.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: asda
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/11/26 15:14:20 
 * @Version: V1.0
 **/
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FansController extends BaseController implements FansControllerApi {
    private final FansService fansService;
    private final UserService userService;
    @Override
    public GraceResult isMeFollowThisWriter(String writerId, String fanId) {
        boolean result = fansService.isMeFollowThisWriter(writerId,fanId);
        return GraceResult.ok(result);
    }

    @Override
    public GraceResult follow(String writerId, String fanId) {
        //判断不为空
        AppUser writer = userService.getUser(writerId);
        AppUser fan = userService.getUser(fanId);
        if (writer == null || fan == null) {
            return GraceResult.errorCustom(ResponseStatusEnum.USER_NOT_EXIST_ERROR);
        }
        fansService.follow(writerId,fanId);
        return GraceResult.ok();
    }

    @Override
    public GraceResult unfollow(String writerId, String fanId) {
        if (!isUserExist(writerId,fanId)){
            return GraceResult.errorCustom(ResponseStatusEnum.USER_NOT_EXIST_ERROR);
        }
        fansService.unfollow(writerId,fanId);
        return GraceResult.ok();
    }
    private boolean isUserExist(String writerId,String fanId){
        //判断不为空
        AppUser writer = userService.getUser(writerId);
        AppUser fan = userService.getUser(fanId);
        if (writer == null || fan == null) {
            return  false;
        }
        return true;
    }

}
