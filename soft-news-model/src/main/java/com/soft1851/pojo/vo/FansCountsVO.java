package com.soft1851.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: sda
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/11/26 15:41:27 
 * @Version: V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FansCountsVO {
    private Integer ManCounts;
    private Integer WomanCounts;
}
