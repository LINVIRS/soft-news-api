package com.soft1851.user.controller;

import com.soft1851.api.controller.user.HelloControllerApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HelloController
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/11/13 22:19:04 
 * @Version: V1.0
 **/
@RestController
public class HelloController implements HelloControllerApi {

    @Override
    public Object hello() {
        return "hello 你好啊";
    }
}
