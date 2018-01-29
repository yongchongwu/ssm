package com.ssm.web.rest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.service.BlogArticleService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BlogArticleResource {

  private final Logger log = LoggerFactory.getLogger(BlogArticleResource.class);

  @Autowired
  private BlogArticleService blogArticleService;

  @GetMapping("/blog-articles")
  public ResponseEntity<PageInfo> selectBlogArticles(@RequestParam(value = "start") Integer start,
      @RequestParam(value = "limit") Integer limit,@RequestParam(value = "orderBy") String orderBy) {
    PageHelper.startPage(start,limit,orderBy);
    List list = blogArticleService.selectBlogArticles();
    PageInfo pageInfo = new PageInfo(list);
    return ResponseEntity.ok().body(pageInfo);
  }

}
