package com.DY.service.impl;

import com.DY.entity.User;
import com.DY.mapper.UserMapper;
import com.DY.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryAllUser() {
        return this.userMapper.queryAllUser();
    }

    @Override
    public User querryUserByIdAndName(String loginName, String password) {
        return this.userMapper.querryUserByIdAndName(loginName, password);
    }

    @Override
    public List<User> querryUserListBykeyAndId(String keywords, Integer userListRoleId) {
        return this.userMapper.querryUserListBykeyAndId(keywords,userListRoleId);
    }

    @Override
    public Integer updateUserByUserId(User user) {
        return this.userMapper.updateUserByUserId(user);
    }

    @Override
    public Integer updateUserStatusByUserId(User user) {
        return this.userMapper.updateUserStatusByUserId(user);
    }

    @Override
    public Integer deleteUserByUserId(Integer userId) {
        return this.userMapper.deleteUserByUserId(userId);
    }

    @Override
    public User querryUserByLoginName(String loginName) {
        return this.userMapper.querryUserByLoginName(loginName);
    }

    @Override
    public Integer addUser(User user) {
        return this.userMapper.addUser(user);
    }

    @Override
    public User qerryUserById(Integer userId) {
        return this.userMapper.qerryUserById(userId);
    }

}
