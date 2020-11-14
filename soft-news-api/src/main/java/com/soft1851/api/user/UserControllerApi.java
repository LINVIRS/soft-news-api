package com.soft1851.api.user;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName: UserControllerApi
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/11/14 19:23:44 
 * @Version: V1.0
 **/
public interface UserControllerApi {
    /**
     * 获取所有用户
     * @return
     */
    @GetMapping("/users")
    Object getUsers();
}
