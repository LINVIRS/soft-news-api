package com.soft1851.api.controller.files;

import com.soft1851.pojo.bo.NewAdminBO;
import com.soft1851.result.GraceResult;
import com.sun.org.apache.bcel.internal.generic.NEW;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: da @Description: TODO @Author: WangLinLIN @Date: 2020/11/21 13:37:53  @Version: V1.0
 */
@Api(
    value = "文件上传Controller",
    tags = {"文件上传controller"})
@RequestMapping("fs")
public interface FileUploadControllerApi {
  /** 上传用户头像 */
  @ApiOperation(value = "上传用户头像", notes = "上传用户头像", httpMethod = "POST")
  @PostMapping("uploadFace")
  GraceResult uploadFile(@RequestParam String userId, MultipartFile file) throws Exception;
  /**
   * 上传多个文件
   *
   * @param userId
   * @param files
   * @return
   * @throws Exception
   */
  @PostMapping("/uploadSomeFiles")
  GraceResult uploadSomeFiles(@RequestParam String userId, MultipartFile[] files) throws Exception;

  /**
   * 文件上传到mogodb的GridFS中
   * @param newAdminBO
   * @param request
   * @param response
   * @return
   * @throws Exception
   */
  @ApiOperation(value = "上传到mongodb的Grids", notes = "上传到mongodb的GridFS", httpMethod = "POST")
  @PostMapping("uploadToGridFS")
  GraceResult uploadToGridFS(
      @RequestBody NewAdminBO newAdminBO, HttpServletRequest request, HttpServletResponse response)
      throws Exception;
}
