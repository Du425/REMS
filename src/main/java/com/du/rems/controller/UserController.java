package com.du.rems.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.du.rems.entity.User;
import com.du.rems.mapper.UserMapper;
import com.du.rems.response.CommonResult;
import com.du.rems.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

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
    public CommonResult queryUserList(){
        List<User> userList = userMapper.selectList(null);
        for (User user : userList) {
            System.out.println(user);
        }
        return CommonResult.success(userList);
    }
    @GetMapping("/queryUser")
    public CommonResult queryUser(@RequestBody User user){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",user.getId())
                .or().eq("username",user.getUsername())
                .or().eq("telephone",user.getTelephone())
                .or().eq("email",user.getEmail());
        User user1 = userMapper.selectOne(queryWrapper);
        if (user1!= null){
            return CommonResult.success("查询成功",user1);
        }else {
            return CommonResult.failed();
        }
    }

    @PostMapping("/addUser")
    public CommonResult addUser(@RequestBody User user){
        if (userMapper.insert(user) == 1){
            return  CommonResult.success("注册成功",user) ;
        } else {
            return CommonResult.failed("注册失败") ;
        }
    }
    @DeleteMapping("/deleteUser")
    public CommonResult deleteUser(User user){
        if (userService.deleteUserByIdOrUsername(user)==1){
            return CommonResult.success("删除成功") ;
        }else {
            return CommonResult.failed("删除失败");
        }

    }
    @PutMapping("/updateUser")
    public CommonResult updateUser(User user){
        int update = userMapper.updateById(user);
        if (update==1){
            return CommonResult.success("修改成功",user) ;
        }else {
            return CommonResult.failed("修改失败");
        }
    }
}

