package com.soft1851.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName: UserAccountInfoVo
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/11/17 10:21:18 
 * @Version: V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAccountInfoVo {
    private  String id;
    private String mobile;
    private String nickname;
    private String face;
    private  String realname;
    private String email;
    private Integer sex;
    private Date birthday;
    private String province;
    private String city;
    private String district;
}
