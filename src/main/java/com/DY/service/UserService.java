package com.DY.service;

import com.DY.entity.User;

import java.util.List;

public interface UserService {

    public List<User> queryAllUser();

    public User querryUserByIdAndName(String loginName,String password);

    /**
     * 根据关键词和用户类型进行查询
     */
    public List<User> querryUserListBykeyAndId(String keywords,Integer userListRoleId);

    /**
     * 根据用户Id修改用户信息
     */
    public Integer updateUserByUserId(User user);
    /**
     * 根据用户Id修改用户可用状态
     */
    public Integer updateUserStatusByUserId(User user);
    /**
     * 根据用户Id删除用户
     */
    public Integer deleteUserByUserId(Integer userId);
    /**
     * 查看当前账号是否存在
     */
    public User querryUserByLoginName(String loginName);
    /**
     * 添加用户
     */
    public Integer addUser(User user);
    /**
     * 根据用户Id查询用户
     */
    public User qerryUserById(Integer userId);
}
