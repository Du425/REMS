package com.du.rems.jwt;

import com.du.rems.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

/**
 * @Author DU425
 * @Date 2022/3/1 16:24
 * @Version 1.0
 * @Description  重写userdetails方法， 似乎可以没有这个类
 */
public class CustomUserDetails extends User implements UserDetails, Serializable {

    public CustomUserDetails(User user) {
        super(user);
    }

    public CustomUserDetails(String username) {
        super(username);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
