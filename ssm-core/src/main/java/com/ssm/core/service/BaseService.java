package com.ssm.core.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

@Service
public abstract class BaseService<T> {

  @Autowired
  protected Mapper<T> mapper;

  public T queryById(Long id) {
    return mapper.selectByPrimaryKey(id);
  }

  public List<T> queryAll() {
    return mapper.selectAll();
  }

  public T queryOne(T record) {
    return mapper.selectOne(record);
  }

  public List<T> queryListByWhere(T record) {
    return mapper.select(record);
  }

  public Integer queryCount(T t) {
    return mapper.selectCount(t);
  }

  public PageInfo<T> queryPageListByWhere(Integer page, Integer rows, T t) {
    PageHelper.startPage(page, rows);
    List<T> list = this.queryListByWhere(t);
    return new PageInfo<T>(list);
  }

  public Integer save(T t) {
    return mapper.insert(t);
  }

  public Integer saveSelective(T t) {
    return mapper.insertSelective(t);
  }

  public Integer update(T t) {
    return mapper.updateByPrimaryKey(t);
  }

  public Integer updateSelective(T t) {
    return mapper.updateByPrimaryKeySelective(t);
  }

  public Integer deleteById(Object id) {
    return mapper.deleteByPrimaryKey(id);
  }

  public Integer deleteByWhere(T record) {
    return mapper.delete(record);
  }

  public Integer deleteByIds(Class<T> clazz, String property, List<Object> values) {
    Example example = new Example(clazz);
    example.createCriteria().andIn(property, values);
    return this.mapper.deleteByExample(example);
  }

}
