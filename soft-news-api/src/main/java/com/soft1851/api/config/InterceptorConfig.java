package com.soft1851.api.config;


import com.soft1851.api.intercepter.PassportInterceptor;
import com.soft1851.api.intercepter.UserTokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 描述:
 *
 * @author：wl
 * @create 2020-11-15 21:04
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Bean
    public PassportInterceptor passportInterceptor(){
        return new PassportInterceptor();
    }
@Bean
public UserTokenInterceptor userTokenInterceptor(){
        return new UserTokenInterceptor();
}
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        注册拦截器，添加拦截路由
        registry.addInterceptor(passportInterceptor())
                .addPathPatterns("/passport/smsCode");
        registry.addInterceptor(userTokenInterceptor())
                .addPathPatterns("/user/")
                .excludePathPatterns("/user/updateUserInfo");
        registry.addInterceptor(userTokenInterceptor()).addPathPatterns("/fans/follow");
    }
}