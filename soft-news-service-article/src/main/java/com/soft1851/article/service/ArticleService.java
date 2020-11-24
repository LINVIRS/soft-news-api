package com.soft1851.article.service;

import com.soft1851.pojo.Category;
import com.soft1851.pojo.bo.NewArticleBO;

/**
 * @ClassName: dasda
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/11/24 19:10:34 
 * @Version: V1.0
 **/
public interface ArticleService {
    /**
     * 发布文章
     * @param newArticleBO
     * @param category
     */
    void  createArticle(NewArticleBO newArticleBO, Category category);
}
