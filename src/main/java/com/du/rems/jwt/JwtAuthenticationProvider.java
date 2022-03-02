package com.du.rems.jwt;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.Assert;

/**
 * @Author DU425
 * @Date 2022/3/2 8:55
 * @Version 1.0
 * @Description
 */
public class JwtAuthenticationProvider implements AuthenticationProvider, InitializingBean, MessageSourceAware {

    protected final Log log = LogFactory.getLog(getClass());
    protected MessageSourceAccessor messageSourceAccessor = SpringSecurityMessageSource.getAccessor();
    private JwtUserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Assert.isInstanceOf(JwtAuthenticationToken.class, authentication, messageSourceAccessor.getMessage(
                "AbstractUserDetailsAuthenticationProvider.onlySupports",
                "Only UsernamePasswordAuthenticationToken is supported"
        ));
        String username = (authentication.getPrincipal() == null) ? "NONE_PROVIDED"
                : authentication.getName();

        JwtAuthenticationToken authenticationToken = (JwtAuthenticationToken) authentication;
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(authenticationToken);

        if (username == null) {
            throw new InternalAuthenticationServiceException("can't obtain user info ");
        }
        username = username.trim();

        org.springframework.security.core.userdetails.UserDetails user = userDetailsService.loadUserByUsername(username);
        if (user == null){
            throw new InternalAuthenticationServiceException("can't obtain user info");
        }
        return new JwtAuthenticationToken(username,(String) authentication.getCredentials(), user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtAuthenticationToken.class.isAssignableFrom(authentication);
    }

    public void setUserDetailsService(JwtUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(this.messageSourceAccessor, "A message source must be set");
        Assert.notNull(this.userDetailsService, "A UserDetailsService must be set");
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSourceAccessor = new MessageSourceAccessor(messageSource);
    }
}
