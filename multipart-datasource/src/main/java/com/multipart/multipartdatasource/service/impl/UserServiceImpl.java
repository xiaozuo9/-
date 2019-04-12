package com.multipart.multipartdatasource.service.impl;

import com.multipart.multipartdatasource.model.User;
import com.multipart.multipartdatasource.service.UserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

import com.multipart.multipartdatasource.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int insert(User user){
        return userMapper.insert(user);
    }

    @Override
    public int insertSelective(User user){
        return userMapper.insertSelective(user);
    }

    @Override
    public int insertList(List<User> users){
        return userMapper.insertList(users);
    }

    @Override
    public int updateByPrimaryKeySelective(User user){
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public List<User> selectAll(){
        return userMapper.selectAll();
    }

    @Override
    public User getUserById(Long id){
        return userMapper.getUserById(id);
    }
}
