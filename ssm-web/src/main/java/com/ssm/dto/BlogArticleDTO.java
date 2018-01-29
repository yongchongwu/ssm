package com.ssm.dto;

import com.ssm.entity.Article;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.type.Alias;

@Alias("blogArticleDTO")
public class BlogArticleDTO implements Serializable {

  private Integer id;
  private Integer user_id;
  private String name;
  private String remark;

  private List<Article> articles;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getUser_id() {
    return user_id;
  }

  public void setUser_id(Integer user_id) {
    this.user_id = user_id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public List<Article> getArticles() {
    return articles;
  }

  public void setArticles(List<Article> articles) {
    this.articles = articles;
  }
}
