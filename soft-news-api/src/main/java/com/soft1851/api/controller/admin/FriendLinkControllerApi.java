package com.soft1851.api.controller.admin;

import com.soft1851.pojo.bo.SaveFriendLinkBO;
import com.soft1851.result.GraceResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @ClassName: dada
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/11/24 15:22:11 
 * @Version: V1.0
 **/
@Api(value = "首页友链维护",tags = {"首页友链维护controller"})
@RequestMapping("friendLinkMng")
public interface FriendLinkControllerApi {
    @ApiOperation(value = "新增修改友链",notes = "新增修改友链",httpMethod = "POST")
    @PostMapping("/saveOrUpdateFriendLink")
    GraceResult saveOrUpdateFriendLink(
            @RequestBody @Valid SaveFriendLinkBO saveFriendLinkBO, BindingResult result);
}
