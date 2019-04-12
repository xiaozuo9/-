package com.multipart.multipartdatasource.service;

import java.util.List;
import com.multipart.multipartdatasource.model.User;
public interface UserService{

    int insert(User user);

    int insertSelective(User user);

    int insertList(List<User> users);

    int updateByPrimaryKeySelective(User user);

    List<User> selectAll();

    User getUserById(Long id);
}
