package com.du.rems.jwt;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @Author DU425
 * @Date 2022/3/1 21:06
 * @Version 1.0
 * @Description
 */
public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private static final long serialVersionUID = 530L;

    private final String token;
    private final String username;

    public JwtAuthenticationToken(String username, String token) {
        super(null);
        this.token = token;
        this.username = username;
        this.setAuthenticated(false);
    }

    public JwtAuthenticationToken(String username, String token, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.token = token;
        this.username = username;
        this.setAuthenticated(false);
    }


    @Override
    public Object getCredentials() {
        return this.token;
    }

    @Override
    public Object getPrincipal() {
        return this.username;
    }

    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException{
        if (isAuthenticated){
            throw new IllegalArgumentException("Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        } else {
            super.setAuthenticated(false);
        }
    }

}
