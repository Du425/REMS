package com.du.rems.jwt;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @Author DU425
 * @Date 2022/3/2 10:23
 * @Version 1.0
 * @Description
 */
@Component
public class JwtUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SecurityContext context = SecurityContextHolder.getContext();
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) context.getAuthentication();
        if (!username.equals(jwtAuthenticationToken.getPrincipal())) {
            throw new UsernameNotFoundException("用户不匹配");
        }

        String token = (String) jwtAuthenticationToken.getCredentials();

        if (JwtTokenUtils.isExpiration(token)) {
            throw new BadCredentialsException("Token过期或无效");
        }

        return new CustomUserDetails(username);
    }
}
