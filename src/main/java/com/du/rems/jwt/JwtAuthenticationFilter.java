package com.du.rems.jwt;

import org.springframework.lang.Nullable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author DU425
 * @Date 2022/3/1 16:25
 * @Version 1.0
 * @Description
 */
public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private static final AntPathRequestMatcher DEFAULT_ANT_PATH_REQUEST_MATCHER = new AntPathRequestMatcher("/1232",
            "POST");

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager){
        super(DEFAULT_ANT_PATH_REQUEST_MATCHER, authenticationManager);
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
       String token = getToken(request);
       String username = getUsername(token);
       JwtAuthenticationToken jwtAuthenticationToken = new JwtAuthenticationToken(username, token);
       setDetails(request,jwtAuthenticationToken);
       return this.getAuthenticationManager().authenticate(jwtAuthenticationToken);

    }

    protected void setDetails(HttpServletRequest request, JwtAuthenticationToken authRequest) {
        authRequest.setDetails(this.authenticationDetailsSource.buildDetails(request));
    }

    @Nullable
    protected String getToken(HttpServletRequest request){
        return request.getHeader("Authentication");
    }

    @Nullable
    protected String getUsername(String token){
        return JwtTokenUtils.getUsername(token);
    }

//    @Nullable
//    protected String getToken(HttpServletRequest request){
//        return request.getParameter();
//    }
}
