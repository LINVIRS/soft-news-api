package com.soft1851.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName: asd
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/11/26 19:05:56 
 * @Version: V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDetailVO {
    private String id;
    private String title;
    private String cover;
    private Integer categoryId;
    private String categoryName;
    private String publishUserId;
    private Date publishTime;
    private String content;
    private String publishUserName;
    private Integer readCounts;
}
