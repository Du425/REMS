package com.du.rems.controller;


import com.du.rems.entity.User;
import com.du.rems.mapper.UserMapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Du425
 * @since 2021-10-31
 */
@Controller
@RequestMapping("/user")
@Api(tags = "用户管理")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/queryUserList")
    public List<User> queryUserList(){
        return userMapper.selectList(null);
    }
    @GetMapping("/addUser")
    public String addUser(@RequestBody User user){
        if(userMapper.insert(user)==1) {
            return "insert success";
        }else{
            return "insert fail";
        }
    }
    @GetMapping("deleteUser")
    public String deleteUser(@RequestParam int id){
        if(userMapper.deleteById(id)==1) {
            return "delete success";
        }else {
            return "delete fail";
        }
    }
    @GetMapping("updateUser")
    public String updateUser(@RequestBody User user) {
        if (userMapper.updateById(user) == 1) {
            return "update success";
        } else {
            return "update fail";
        }
    }
    @GetMapping("queryUserById")
    public User queryUserById(@RequestParam int id) {
        return userMapper.selectById(id);
    }
}

