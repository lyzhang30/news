package com.DY.controller;

import com.DY.entity.Role;
import com.DY.entity.User;
import com.DY.service.RoleService;
import com.DY.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping(value="/toFindUserList")
    public String toFindUserList(String keywords, Integer userListRoleId,Model model){
        List<Role> roleList = roleService.querryRoleList();
        model.addAttribute("roleList",roleList);
        List<User> userList = this.userService.querryUserListBykeyAndId(keywords, userListRoleId);
        model.addAttribute("userList",userList);
        model.addAttribute("keywords",keywords);
        model.addAttribute("userListRoleId",userListRoleId);
        return "user/userList";
    }

    @RequestMapping(value ="/findUserList")
    public String findUserList(String keywords, Integer userListRoleId, Model model){
        List<Role> roleList = roleService.querryRoleList();
        model.addAttribute("roleList",roleList);
        List<User> userList = this.userService.querryUserListBykeyAndId(keywords, userListRoleId);
        model.addAttribute("userList",userList);
        model.addAttribute("keywords",keywords);
        model.addAttribute("userListRoleId",userListRoleId);
        return "user/userList";
    }

    /**跳转到编辑用户界面**/
    //转向添加用户
    @RequestMapping(value="/toAddUser")
    public String toAddUser(Model model){
        //获取角色列表，用于添加用户页面中的用户角色下拉列表
        List<Role> roleList=roleService.querryRoleList();
        model.addAttribute("roleList", roleList);
        return "user/addUser";
    }

    /**查询当前账户是否存在**/
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUser(User user,Model model){
        //获取用户列表
        List<Role> roleList = roleService.querryRoleList();
        model.addAttribute("roleList",roleList);
        model.addAttribute("user",user);
        User checkUser = this.userService.querryUserByLoginName(user.getLoginName());
        if(checkUser != null){
            model.addAttribute("checkUserLoginNameMsg","该账户已存在，请重新输入");
            return "user/addUser";
        }else{
            Date date= new Date();
            user.setRegisterTime(date);
            user.setStatus("2");
            Integer ret = this.userService.addUser(user);
            if(ret >0){
                return "redirect:toFindUserList";
            }else{
                return "user/addUser";
            }
        }

    }

    /**跳转到修改用户界面**/
    @RequestMapping(value = "/toEditUser")
    public String toEditUser(Integer userId,Model model){
        User user = this.userService.qerryUserById(userId);
        if(user != null){
            model.addAttribute("user",user);
//            获取角色列表
            List<Role> roleList = this.roleService.querryRoleList();
            model.addAttribute("roleList",roleList);
            return "user/editUser";
        }else{
            return "redirect:findUserList";
        }
    }

    /*****修改用户信息*******/
    @RequestMapping(value ="/editUser",method =RequestMethod.POST)
    public String editUser(User user,Model model){
        Date date= new Date();
        user.setRegisterTime(date);
        user.setStatus("2");
        Integer ret = this.userService.updateUserByUserId(user);
        if(ret >0){
            return "redirect:toFindUserList";
        }else{
            List<Role> roleList = this.roleService.querryRoleList();
            model.addAttribute("roleList",roleList);
            model.addAttribute("user",user);
            return "user/editUser";
        }
    }

    /****删除用户********/
    @RequestMapping(value ="/delUser")
    @ResponseBody
    public User delUser( @RequestBody User user,Model model){
        int rows = this.userService.deleteUserByUserId(user.getUserId());
        if(rows>0){
            System.out.println("删除成功");
            return user;
        }else{
            user.setUserId(0);
            return user;
        }

    }

    /*****启用用户'2'**********/
    @RequestMapping(value ="/enableUser")
    @ResponseBody
    public User enableUser (@RequestBody User user,Model model){
        Integer ret = this.userService.updateUserStatusByUserId(user);
        if(ret>0){
            return user;
        }else{
            user.setUserId(0);
            return user;
        }
    }

    /***********禁用用户 '3'*********/
    @RequestMapping(value ="/disableUser")
    @ResponseBody
    public User disableUser(@RequestBody User user,Model model){
        int rows = this.userService.updateUserStatusByUserId(user);
        if(rows >0){
            return  user;
        }else{
            user.setUserId(0);
            return user;
        }
    }

    /***退出登录页面******/
    @RequestMapping(value ="/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "../../login";
    }

}
