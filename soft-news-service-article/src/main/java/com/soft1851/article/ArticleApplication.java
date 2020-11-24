package com.soft1851.article;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @ClassName: ArticleApplication @Description: TODO @Author: WangLinLIN @Date:
 * 2020/11/24 16:26:00  @Version: V1.0
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.soft1851", "org.n3r.idworker"})
@MapperScan(basePackages = "com.soft1851.article.mapper")
public class ArticleApplication {
  public static void main(String[] args) {
    SpringApplication.run(ArticleApplication.class, args);
  }
}
