package com.ssm.web.rest;

import com.ssm.entity.Blog;
import com.ssm.service.BlogService;
import javax.validation.Valid;
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
public class BlogResource {

  private final Logger log = LoggerFactory.getLogger(BlogResource.class);

  @Autowired
  private BlogService blogService;

  @PostMapping("/blogs")
  public ResponseEntity<Blog> createBlog(@Valid @RequestBody Blog blog){

    blogService.addBlog(blog);
    return ResponseEntity.ok().body(blog);
  }

  @PutMapping("/blogs")
  public ResponseEntity<Blog> updateBlog(@Valid @RequestBody Blog blog){
    if(null==blog.getId()){
      return createBlog(blog);
    }
    blogService.updateBlog(blog);
    return ResponseEntity.ok().body(blog);
  }

}
