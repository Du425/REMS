package com.du.rems.jwt.securityHandler;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;

/**
 * @Author DU425
 * @Date 2022/2/6 17:59
 * @Version 1.0
 * @Description
 */
public class CustomizeFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    AntPathMatcher antPathMatcher = new AntPathMatcher();


    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
