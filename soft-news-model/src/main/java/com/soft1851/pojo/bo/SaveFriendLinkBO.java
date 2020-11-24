package com.soft1851.pojo.bo;

import com.soft1851.pojo.validate.CheckUrl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @ClassName: asdsa @Description: TODO @Author: WangLinLIN @Date: 2020/11/24 15:07:04  @Version:
 * V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaveFriendLinkBO {
  private String id;

  @NotNull(message = "请选择保留或者删除")
  private Integer isDelete;

  @NotBlank(message = "友情链接名不能为空")
  private String linkName;

  @NotBlank(message = "友情链接地址不能为空")
  @CheckUrl
  private String linkUrl;
}
