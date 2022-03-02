package com.du.rems.jwt;

import com.du.rems.jwt.securityHandler.CustomizeAuthenticationFailureHandler;
import com.du.rems.jwt.securityHandler.CustomizeAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * @Author DU425
 * @Date 2022/3/2 10:54
 * @Version 1.0
 * @Description
 */
@Component
public class JwtAuthenticationSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Autowired
    private CustomizeAuthenticationFailureHandler customizeAuthenticationFailureHandler;
    @Autowired
    private CustomizeAuthenticationSuccessHandler customizeAuthenticationSuccessHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //创建并配置好自定义JwtAuthenticationfilter，
        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(http.getSharedObject(AuthenticationManager.class));

        jwtAuthenticationFilter.setAuthenticationSuccessHandler(customizeAuthenticationSuccessHandler);
        jwtAuthenticationFilter.setAuthenticationFailureHandler(customizeAuthenticationFailureHandler);
        //创建并配置好自定义SmsAuthenticationProvide
        JwtAuthenticationProvider jwtAuthenticationProvider = new JwtAuthenticationProvider();
        jwtAuthenticationProvider.setUserDetailsService(userDetailsService);

        http.authenticationProvider(jwtAuthenticationProvider);
        //将过滤器添加到过滤链路中
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
