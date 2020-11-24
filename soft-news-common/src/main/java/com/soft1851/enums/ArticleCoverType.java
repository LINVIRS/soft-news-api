package com.soft1851.enums;

/**
 * @ClassName: dasd
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/11/24 19:12:52 
 * @Version: V1.0
 **/
public enum  ArticleCoverType {
    ONE_IMAGE(1,"单图"),
    WORDS(2,"纯文字");
    public final Integer type;
    public final String value;
    ArticleCoverType(Integer type,String value){
        this.type = type;
        this.value = value;
    }
}
