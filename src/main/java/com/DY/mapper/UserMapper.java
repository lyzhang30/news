package com.DY.mapper;

import com.DY.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**
     * 查询全部用户
     * @return
     */
    List<User> queryAllUser();
    /**
     * 根据用户名称和密码登录账户
     */
    User querryUserByIdAndName( @Param("loginName")String loginName,@Param("password")String password);
    /**
     * 根据关键词和用户的角色ID查询
     */
    public List<User> querryUserListBykeyAndId(@Param("keywords") String keywords,@Param("userListRoleId") Integer userListRoleId);
    /**
     *根据用户Id修改用户信息
     */
    public Integer updateUserByUserId(User user);
    /**
     * 根据用户Id修改用户的登录状态
     */
    public Integer updateUserStatusByUserId(User user);
    /**
     * 根据用户Id删除用户
     */
    public Integer deleteUserByUserId(Integer userId);
    /**
     * 查看当前账户名称是否存在
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
