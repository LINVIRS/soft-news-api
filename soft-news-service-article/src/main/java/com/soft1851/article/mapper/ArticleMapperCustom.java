package com.soft1851.article.mapper;

import org.springframework.stereotype.Repository;

/**
 * @ClassName: ads
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/11/25 11:20:44 
 * @Version: V1.0
 **/
@Repository
public interface ArticleMapperCustom {
    /**
     * 更新文章发布状态：定时->即时发布
     */
    void updateAppointToPublish();
}
