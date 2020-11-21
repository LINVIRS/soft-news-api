package com.soft1851.files.controller;


import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.soft1851.api.controller.files.FileUploadControllerApi;
import com.soft1851.files.resource.FileResource;
import com.soft1851.files.service.UploadService;
import com.soft1851.pojo.bo.NewAdminBO;
import com.soft1851.result.GraceResult;
import com.soft1851.result.ResponseStatusEnum;
import com.soft1851.utils.extend.AliImageReviewUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: das @Description: TODO @Author: WangLinLIN @Date: 2020/11/21 13:36:21  @Version: V1.0
 */
@RestController
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FileUploadController implements FileUploadControllerApi {
  private final UploadService uploadService;
  private final FileResource fileResource;
  private final AliImageReviewUtil aliImageReviewUtil;
  private final GridFSBucket gridFSBucket;
  @Resource
  private GridFsTemplate gridFsTemplate;

  @Override
  public GraceResult uploadFile(String userId, MultipartFile file) throws Exception {
    String path;
    if (file != null) {
      // 获得文件上传的名称
      String fileName = file.getOriginalFilename();
      // 判断文件名不能为空
      if (StringUtils.isNotBlank(fileName)) {
        // 分割文件名
        String[] fileNameArr = fileName.split("\\.");
        // 获得后缀
        String suffix = fileNameArr[fileNameArr.length - 1];
        // 判断后缀符合我们的预定义规范
        if (!"png".equalsIgnoreCase(suffix)
            && !"jpg".equalsIgnoreCase(suffix)
            && !"jpeg".equalsIgnoreCase(suffix)) {
          return GraceResult.errorCustom(ResponseStatusEnum.FILE_FORMATTER_FAILD);
        }
        // 执行上传服务，得到回调路径
        path = uploadService.uploadFile(file, suffix);
      } else {
        return GraceResult.errorCustom(ResponseStatusEnum.FILE_UPLOAD_NULL_ERROR);
      }
    } else {
      return GraceResult.errorCustom(ResponseStatusEnum.FILE_UPLOAD_NULL_ERROR);
    }
    log.info("path=" + path);
    String finalPath;
    if (StringUtils.isNotBlank(path)) {
      finalPath = fileResource.getHost() + path;
    } else {
      return GraceResult.errorCustom(ResponseStatusEnum.FILE_UPLOAD_FAILD);
    }
    return GraceResult.ok(doAllImageReview(finalPath));
  }

  /** 检测不通过的默认图片 */
  public static final String FAILED_IMAGE_URL =
      "https://smart-campus-third.oss-cn-hangzhou.aliyuncs.com/avatar/failed.jpg";

  private String doAllImageReview(String pendingImageUrl) {
    log.info(pendingImageUrl);
    boolean result = false;
    try {
      result = aliImageReviewUtil.reviewImage(pendingImageUrl);
    } catch (Exception e) {
      System.err.println("图片识别出错");
    }
    if (!result) {
      return FAILED_IMAGE_URL;
    }
    return pendingImageUrl;
  }

  @Override
  public GraceResult uploadSomeFiles(String userId, MultipartFile[] files) throws Exception {
    // 声明List，用于存改多个图片的地址路径，返回到前端
    List<String> imageUrlList = new ArrayList<>();
    if (files != null && files.length > 0) {
      for (MultipartFile file : files) {
        String path = null;
        if (file != null) {
          // 获得上传文件的名称
          String fileName = file.getOriginalFilename();
          // 判断文件名不能为空
          if (StringUtils.isNotBlank(fileName)) {
            String[] fileNameArr = fileName.split("\\.");
            // 获得后缀
            String suffix = fileNameArr[fileNameArr.length - 1];
            // 判断后缀符合我们的预定义规范
            if (!"png".equalsIgnoreCase(suffix)
                && !"jpg".equalsIgnoreCase(suffix)
                && !"jpeg".equalsIgnoreCase(suffix)) {
              continue;
            }
            // 执行上传
            path = uploadService.uploadOSS(file, userId, suffix);
          }
        } else {
          continue;
        }
        String finalPath;
        if (StringUtils.isNotBlank(path)) {
          finalPath = fileResource.getOssHost() + path;
          imageUrlList.add(finalPath);
        }
      }
    }
    return GraceResult.ok(imageUrlList);
  }

  @Override
  public GraceResult uploadToGridFS(
      NewAdminBO newAdminBO, HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    // base64字符串
    String file64 = newAdminBO.getImg64();
    // 将字符转转化为byte数组
    byte[] bytes = new BASE64Decoder().decodeBuffer(file64.trim());
    // 转化为输入流
    ByteArrayInputStream InputStream = new ByteArrayInputStream(bytes);
    // 上传
    ObjectId fileId = gridFSBucket.uploadFromStream(newAdminBO.getUsername() + ".jpg", InputStream);
    System.out.println("上传完成。文件Id" + fileId);
    // 问哪家在mongodb中Id
    String fileIdStr = fileId.toString();
    System.out.println("fileIdStr=" + fileIdStr);
    return GraceResult.ok(fileIdStr);
  }

  @Override
  public void readInGridFs( String faceId, HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    // 根据id查询文件
    GridFSFile gridFSFile = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(faceId)));
    if (gridFSFile == null) {
      throw new RuntimeException("No file with id: " + faceId);
    }
    System.out.println(gridFSFile.getFilename());
    // 获取流对象
    GridFsResource resource = gridFsTemplate.getResource(gridFSFile);
    InputStream inputStream;
    String content = null;
    byte[] bytes = new byte[(int) gridFSFile.getLength()];
    try {
      inputStream = resource.getInputStream();
      int read = inputStream.read(bytes);
      inputStream.close();
      ServletOutputStream outputStream = response.getOutputStream();
      outputStream.write(bytes);
      outputStream.close();
      //// 获取流中的数据
      // content = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
      //// 获取byte[]信息
      // bytes = IOUtils.toByteArray(inputStream);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
