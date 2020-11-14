package com.soft1851.api.user;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName: User
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/11/13 22:22:48 
 * @Version: V1.0
 **/
public interface HelloControllerApi {
    /**
     * hello接口
     * @return
     */
    @GetMapping("/hello")
    Object hello();
}
