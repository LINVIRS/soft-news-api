package com.soft1851.admin.repository;

import com.soft1851.pojo.mo.FriendLinkMO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @ClassName: adsda
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/11/24 15:09:16 
 * @Version: V1.0
 **/
public interface FriendLinkRepository extends MongoRepository<FriendLinkMO,String> {
    /**
     * 根据是否删除查询所有友链
     * @param isDelete
     * @return
     */
    List<FriendLinkMO> getAllByIsDelete(Integer isDelete);
}