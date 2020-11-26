package com.soft1851.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: ads
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/11/26 15:33:23 
 * @Version: V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegionRatioVO {
    private String name;
    private Integer value;
}

