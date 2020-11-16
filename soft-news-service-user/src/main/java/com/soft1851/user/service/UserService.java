package com.soft1851.user.service;

import com.soft1851.pojo.AppUser;

/**
 * @ClassName: UserService
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/11/16 21:26:53 
 * @Version: V1.0
 **/
public interface UserService {

    /**
     * 判断用户是否存在，如果存在返回 user 信息
     *
     * @param mobile
     * @return
     */
    AppUser queryMobileIsExist(String mobile);

    /**
     * 创建用户、新增用户记录到数据库
     *
     * @param mobile
     * @return
     */
    AppUser createUser(String mobile);
}