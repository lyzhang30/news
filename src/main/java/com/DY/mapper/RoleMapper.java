package com.DY.mapper;

import com.DY.entity.Role;

import java.util.List;

/**
 * 角色接口
 */
public interface RoleMapper {
    /**
     * 查询用户角色列表
     * @return
     */
    public List<Role> querryRoleList();
    /**
     * 根据角色ID获取关联的用户
     */

}
