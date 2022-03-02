package com.du.rems.config.service;

import com.du.rems.jwt.JwtAuthenticationFilter;
import com.du.rems.jwt.JwtAuthenticationSecurityConfig;
import com.du.rems.jwt.UsernamePasswordUserDetailsService;
import com.du.rems.jwt.securityHandler.CustomizeAccessDeniedHandler;
import com.du.rems.jwt.securityHandler.CustomizeAuthenticationEntryPoint;
import com.du.rems.jwt.securityHandler.CustomizeLogoutSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author DU425
 * @Date 2022/3/1 19:00
 * @Version 1.0
 * @Description
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomizeAuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    private CustomizeAccessDeniedHandler accessDeniedHandler;

    @Autowired
    private CustomizeLogoutSuccessHandler logoutSuccessHandler;

    @Autowired
    private JwtAuthenticationSecurityConfig jwtAuthenticationSecurityConfig;

    @Autowired
    private UsernamePasswordUserDetailsService usernamePasswordUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();

        http.authorizeRequests()
                .antMatchers(HttpMethod.POST,"/login/form").permitAll()

                .and()
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler)

                .and()
                .apply(jwtAuthenticationSecurityConfig)

                .and()
                .logout()
                .logoutSuccessHandler(logoutSuccessHandler)
//                .and()
//                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    /**
     * 因为使用了BCryptPasswordEncoder来进行密码的加密，所以身份验证的时候也的用他来判断
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService getUserDetailsService(){
        return usernamePasswordUserDetailsService;
    }
}
