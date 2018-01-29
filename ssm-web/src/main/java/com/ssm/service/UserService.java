package com.ssm.service;

import com.ssm.dao.UserMapper;
import com.ssm.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserMapper userMapper;

  public List<User> getAll() {
    return userMapper.selectAll();
  }

  public User getOne(Integer id) {
    return userMapper.selectByPrimaryKey(id);
  }

  public User selectUser(Integer id) {
    return userMapper.selectUser(id);
  }

  public List<User> selectAllUser() {
    return userMapper.selectAllUser();
  }
}
