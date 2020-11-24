package com.soft1851.admin.service;

import com.soft1851.pojo.mo.FriendLinkMO;

import java.util.List;

/**
 * @ClassName: dassa
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/11/24 15:11:38 
 * @Version: V1.0
 **/
public interface FriendLinkService {
    /**
     *新增或者更新友情链接
     *
     * @param friendLinkMO
     */
    void saveOrUpdateFriendLink(FriendLinkMO friendLinkMO);

    /**
     * 查询 mogodb
     * @return
     */
    List<FriendLinkMO> queryAllFriendLinkList();

    /**
     * 删除
     * @param linkId
     */
    void delete(String linkId);
}
