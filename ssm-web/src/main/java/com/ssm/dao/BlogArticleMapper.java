package com.ssm.dao;

import com.ssm.dto.BlogArticleDTO;
import java.util.List;

public interface BlogArticleMapper {

  List<BlogArticleDTO> selectBlogArticles();

}
