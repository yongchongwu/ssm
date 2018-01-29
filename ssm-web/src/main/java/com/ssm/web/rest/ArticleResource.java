package com.ssm.web.rest;

import com.ssm.entity.Article;
import com.ssm.service.ArticleService;
import com.ssm.utils.DateTools;
import javax.validation.Valid;
import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ArticleResource {

  private final Logger log = LoggerFactory.getLogger(ArticleResource.class);

  @Autowired
  private ArticleService articleService;

  @PostMapping("/articles")
  public ResponseEntity<Article> createArticle(@Valid @RequestBody Article article) {
    //article.setAddTime(DateTime.now().toDate());
    article.setAddTime(DateTools.todayDate());
    //articleService.addArticle(article);
    articleService.save(article);
    return ResponseEntity.ok().body(article);
  }

  @PutMapping("/articles")
  public ResponseEntity<Article> updateArticle(@Valid @RequestBody Article article) {
    if (null == article.getId()) {
      return createArticle(article);
    }
    article.setUpdateTime(DateTime.now().toDate());
    //articleService.updateArticle(article);
    articleService.updateArticle(article);
    article=articleService.getArticle(article.getId());
    return ResponseEntity.ok().body(article);
  }

}

