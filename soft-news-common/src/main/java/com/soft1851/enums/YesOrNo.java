package com.soft1851.enums;

/**
 * @ClassName: dsa
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/11/24 19:14:05 
 * @Version: V1.0
 **/
public enum YesOrNo {
    NO(0,"否"),
    YES(1,"是");
    public final Integer type;
    private final String value;

    YesOrNo(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}

