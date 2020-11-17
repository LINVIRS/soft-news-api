package com.soft1851.api.intercepter;

/**
 * @ClassName: das
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/11/17 15:05:49 
 * @Version: V1.0
 **/

import com.soft1851.exception.GraceException;
import com.soft1851.result.ResponseStatusEnum;
import com.soft1851.utils.RedisOperator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description: 基础拦截器
 * @author: mqxu
 * @create: 2020-11-17 14:27
 **/
public class BaseInterceptor {

    @Autowired
    private RedisOperator redis;

    public static final String REDIS_USER_TOKEN = "redis_user_token";
    public static final String REDIS_ADMIN_TOKEN = "redis_admin_token";

    public boolean verifyUserIdToken(String id, String token, String redisKeyPrefix) {
        if (StringUtils.isNotBlank(id) && StringUtils.isNotBlank(token)) {
            String uniqueToken = redis.get(redisKeyPrefix + ":" + id);
            if (StringUtils.isBlank(uniqueToken)) {
                GraceException.display(ResponseStatusEnum.UN_LOGIN);
                return false;
            } else {
                if (!uniqueToken.equals(token)) {
                    GraceException.display(ResponseStatusEnum.TICKET_INVALID);
                    return false;
                }
            }
        } else {
            GraceException.display(ResponseStatusEnum.UN_LOGIN);
            return false;
        }

        // false: 请求被拦截，被驳回，验证出现问题;true: 请求在经过验证校验以后，确认是可以放行的
        return true;
    }
}