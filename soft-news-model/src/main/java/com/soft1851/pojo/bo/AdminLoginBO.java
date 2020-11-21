package com.soft1851.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: AdminLoginBo
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/11/21 15:03:39 
 * @Version: V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminLoginBO {
    private String username;
    private String password;
    private String img64;
}