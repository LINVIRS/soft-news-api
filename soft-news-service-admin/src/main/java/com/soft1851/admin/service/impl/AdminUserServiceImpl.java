package com.soft1851.admin.service.impl;

import com.soft1851.admin.mapper.AdminUserMapper;
import com.soft1851.admin.service.AdminUserService;
import com.soft1851.pojo.AdminUser;
import lombok.RequiredArgsConstructor;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @ClassName: AdminUserServiceImpl
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/11/21 15:01:03 
 * @Version: V1.0
 **/
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AdminUserServiceImpl implements AdminUserService {
    private final AdminUserMapper adminUserMapper;
    private final Sid sid;
    @Override
    public AdminUser queryAdminByUsername(String username) {
        Example adminUserExample = new Example(AdminUser.class);
        Example.Criteria adminUserCriteria = adminUserExample.createCriteria();
        adminUserCriteria.andEqualTo("username",username);
        return adminUserMapper.selectOneByExample(adminUserExample);
    }
}
