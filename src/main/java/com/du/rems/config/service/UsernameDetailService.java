package com.du.rems.config.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.du.rems.entity.User;
import com.du.rems.mapper.UserMapper;
import lombok.SneakyThrows;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class UsernameDetailService implements UserDetailsService{

    @Autowired
    UserMapper userMapper;

    @Override
    @SneakyThrows
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null || "".equals(username)){
            throw new UsernameNotFoundException("用户名不能为空");
        }
        final QueryWrapper<User> queryWrapper = new QueryWrapper<User>().eq("username",username);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null){
            throw new UsernameNotFoundException("该用户不存在");
        }
        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("user");
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }
}
