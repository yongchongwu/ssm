package com.ssm.service;

import com.ssm.dao.BlogArticleMapper;
import com.ssm.dto.BlogArticleDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogArticleService {

  @Autowired
  private BlogArticleMapper blogArticleMapper;

  public List<BlogArticleDTO> selectBlogArticles() {
    return blogArticleMapper.selectBlogArticles();
  }
}
