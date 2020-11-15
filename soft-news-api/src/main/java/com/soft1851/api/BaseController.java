package com.soft1851.api;

import com.soft1851.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName: BaseController
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/11/15 21:43:14 
 * @Version: V1.0
 **/
public class BaseController {
    //声明public 要不子类不能使用
    @Autowired
    public RedisOperator redis;
    public static final  String MOBILE_SMSCODE="mobile:smscode";
}
