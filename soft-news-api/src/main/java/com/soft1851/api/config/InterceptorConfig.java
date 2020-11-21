package com.soft1851.api.config;


import com.soft1851.api.intercepter.*;
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
    @Bean
    public UserActiveInterceptor userActiveInterceptor(){
        return  new UserActiveInterceptor();
    }
    @Bean
    public UploadFileInterceptor uploadFileInterceptor(){
        return new UploadFileInterceptor();
    }
        @Bean
    public AdminTokenInterceptor adminTokenInterceptor() {
        return new AdminTokenInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        注册拦截器，添加拦截路由
        registry.addInterceptor(passportInterceptor())
                .addPathPatterns("/passport/smsCode");
//        对有些接口拦截未带token以及userId的请求
        registry.addInterceptor(userTokenInterceptor())
                .addPathPatterns("/user/userBasicInfo")
                .addPathPatterns("/user/updateUserInfo");
//        拦截所有请求
        registry.addInterceptor(userActiveInterceptor())
                .addPathPatterns("/user/fans/follow");
        registry.addInterceptor(uploadFileInterceptor())
                .addPathPatterns("/fs/uploadFace")
                .addPathPatterns("/fs/uploadSomeFiles");
        registry.addInterceptor(adminTokenInterceptor())
                .addPathPatterns("/adminMsg/adminIsExist");
    }
}
