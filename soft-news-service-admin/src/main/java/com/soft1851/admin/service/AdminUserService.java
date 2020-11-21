package com.soft1851.admin.service;

import com.soft1851.pojo.AdminUser;

/**
 * @interface: AdminUserService
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/11/21 15:00:33 
 * @Version: V1.0
 **/
public interface AdminUserService {
    /**
     * 获得管理员用户信息
     * @param username 用户名
     * @return AdminUser
     */
    AdminUser queryAdminByUsername(String username);

}
