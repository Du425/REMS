package com.du.rems.jwt;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.du.rems.entity.User;
import com.du.rems.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @Author DU425
 * @Date 2022/3/1 16:24
 * @Version 1.0
 * @Description
 */
@Component
public class UsernamePasswordUserDetailsService implements UserDetailsService {

    @Autowired
    IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getOne(new QueryWrapper<User>().eq("username",username));
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return new CustomUserDetails(user);
    }
}
