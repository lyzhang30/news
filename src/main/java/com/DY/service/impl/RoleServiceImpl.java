package com.DY.service.impl;

import com.DY.entity.Role;
import com.DY.mapper.RoleMapper;
import com.DY.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public List<Role> querryRoleList() {
        return this.roleMapper.querryRoleList();
    }

}
