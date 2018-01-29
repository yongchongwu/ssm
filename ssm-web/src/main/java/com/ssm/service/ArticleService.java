package com.ssm.service;

import com.ssm.core.service.BaseService;
import com.ssm.dao.ArticleMapper;
import com.ssm.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService extends BaseService<Article> {

  @Autowired
  private ArticleMapper articleMapper;

  public Article getArticle(Integer id) {
    return  articleMapper.selectByPrimaryKey(id);
  }

  public void addArticle(Article article) {
    articleMapper.insert(article);
  }

  public void updateArticle(Article article) {
    //articleMapper.updateByPrimaryKey(article);
    articleMapper.updateByPrimaryKeySelective(article);
  }
}
