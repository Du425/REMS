package com.du.rems.controller;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.du.rems.dto.LoginDto;
import com.du.rems.entity.User;
import com.du.rems.mapper.AccountMapper;
import com.du.rems.response.CommonResult;
import com.du.rems.service.IUserService;
import com.du.rems.util.JwtUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class LoginController {
    @Autowired
    IUserService iUserService;
    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/login")
    public CommonResult login(@Validated @RequestBody LoginDto loginDto, HttpServletResponse response){
        User user = iUserService.getOne(new UpdateWrapper<User>().eq("username", loginDto.getUsername()));
        Assert.notNull(user,"用户不存在");
        if (!user.getPassword().equals(SecureUtil.md5(loginDto.getPassword()))){
            return CommonResult.failed("密码不正确");
        }else {
            String jwt = jwtUtil.generateToken(user.getId());
//将token 放在我们的header里面
            response.setHeader("Authorization",jwt);
            response.setHeader("Access-control-Expose-Headers","Authorization");

            return CommonResult.success(MapUtil.builder()
                    .put("id",user.getId())
                    .put("nick",user.getNick())
                    .put("username",user.getUsername())
                    .put("telephone",user.getTelephone())
                    .put("email",user.getEmail())
                    .put("sum_money",user.getSumMoney())
                    .put("money_spend",user.getMoneySpend())
                    .map()
            );
        }
    }

    //需要认证权限才能退出登录
    @RequiresAuthentication
    @GetMapping("/logout")
    public CommonResult logout(){
        SecurityUtils.getSubject().logout();
        return CommonResult.success(null);
    }
}
