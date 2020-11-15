package com.soft1851.user.controller;

import com.soft1851.api.user.HelloControllerApi;
import com.soft1851.result.GraceResult;
import com.soft1851.utils.RedisOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName: HelloController
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/11/13 22:19:04 
 * @Version: V1.0
 **/
@RestController
@Slf4j
public class HelloController implements HelloControllerApi {
@Resource
private RedisOperator redis;
    @Override
    public Object hello() {
        log.info("info ,hello");
        log.warn("warn hello");
        log.error("error hello");
        return GraceResult.ok("hello");
    }

    /**
     * redis测试
     * @return
     */
    @GetMapping("redis")
    public GraceResult redis(){
        redis.set("age","20");
        return  GraceResult.ok(redis.get("age"));
    }
}
