package com.soft1851.files.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName: dasda
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/11/21 13:32:44 
 * @Version: V1.0
 **/
public interface UploadService {
    /**
     * fdfs文件上传
     * @param file 文件
     * @param fileExtName 文件扩展名
     * @return
     * @throws Exception
     */
    String uploadFile(MultipartFile file, String fileExtName) throws Exception;
}
