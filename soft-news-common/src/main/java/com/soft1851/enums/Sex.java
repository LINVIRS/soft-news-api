package com.soft1851.enums;

/**
 * @ClassName: sad
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/11/26 15:37:22 
 * @Version: V1.0
 **/
public enum Sex {
    man(1),
    woman(0);
    public final Integer type;

    Sex(Integer type) {
        this.type = type;
    }
}
