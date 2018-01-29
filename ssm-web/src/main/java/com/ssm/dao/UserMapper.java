package com.ssm.dao;

import com.ssm.entity.User;
import java.util.List;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {
    User selectUser(Integer user_id);

    List<User> selectAllUser();
}
