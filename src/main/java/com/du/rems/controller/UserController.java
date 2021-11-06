package com.du.rems.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.du.rems.entity.User;
import com.du.rems.mapper.UserMapper;
import com.du.rems.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Du425
 * @since 2021-11-06
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IUserService userService;

    @GetMapping("/queryUserList")
    public List<User> queryUserList(){
        List<User> userList = userMapper.queryUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        return userList;
    }

    @PostMapping("/addUser")
    public String addUser(User user){
        if (userMapper.insert(user) == 1){
            return "注册成功";
        } else {
            return "注册失败";
        }
    }
    @DeleteMapping("/deleteUser")
    public String deleteUser(User user){
        if (userService.deleteUserByIdOrUsername(user)==1){
            return "删除成功";
        }else {
            return "删除失败";
        }

    }
    @PutMapping("/updateUser")
    public String updateUser(User user){
        int update = userMapper.updateById(user);
        if (update==1){
            return "修改成功";
        }else {
            return "修改失败";
        }

//        userMapper.update();

    }
}

