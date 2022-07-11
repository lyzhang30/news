package com.DY.controller;

import com.DY.entity.Role;
import com.DY.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller

public class RoleController {
    @Autowired
    private RoleService roleService;
    @RequestMapping(value="/findRoleList",method= RequestMethod.GET)
    public String findRoleList(Model model ){
        List<Role> roleList = roleService.querryRoleList();
        if(roleList.size() > 0){
            model.addAttribute("role",roleList.get(0));
        }
        return "role/roleList";
    }
}
