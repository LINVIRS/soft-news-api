package com.soft1851.article.controller;

import com.soft1851.api.BaseController;
import com.soft1851.api.controller.Category.CategoryControllerApi;
import com.soft1851.article.service.CategoryService;
import com.soft1851.pojo.Category;
import com.soft1851.result.GraceResult;
import com.soft1851.utils.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: asda
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/11/24 19:17:24 
 * @Version: V1.0
 **/
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CategoryController extends BaseController implements CategoryControllerApi {
    private final CategoryService categoryService;

    @Override
    public GraceResult getAll() {
        //0,先从redis中查询，如果有就返回，如果空就查询数据库后放缓存再返回
        String allCategoryJson = redis.get(REDIS_ALL_CATEGORY);
        List<Category> categoryList;
        if (StringUtils.isBlank(allCategoryJson)){
            //如果redis中没有数据，则从数据库中查询所有文章分类
            categoryList = categoryService.selectAll();
            //存入redis
            redis.set(REDIS_ALL_CATEGORY, JsonUtil.objectToJson(categoryList));
        }else {
            //否则，redis有数据，直接转换为List返回
            categoryList = JsonUtil.jsonToList(allCategoryJson,Category.class);
        }
        return GraceResult.ok(categoryList);
    }
}
