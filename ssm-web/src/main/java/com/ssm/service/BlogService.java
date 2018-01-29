package com.ssm.service;

import com.ssm.dao.BlogMapper;
import com.ssm.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

  @Autowired
  private BlogMapper blogMapper;

  public void addBlog(Blog blog) {
    blogMapper.insert(blog);
  }
  public void updateBlog(Blog blog) {
    blogMapper.updateByPrimaryKey(blog);
  }

}
