package com.du.rems.jwt.securityHandler;

import com.alibaba.fastjson.JSON;
import com.du.rems.response.CommonResult;
import com.du.rems.response.ResultType;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author DU425
 * @Date 2022/1/22 17:35
 * @Version 1.0
 * @Description: 登录失败处理逻辑
 * 什么情况下认证失败，是不是与exception重复了
 */
@Component
public class CustomizeAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        CommonResult result = null;
        if (e instanceof AccountExpiredException){
            result = CommonResult.failed(ResultType.USER_ACCOUNT_EXPIRED);
        } else if (e instanceof BadCredentialsException){
            result = CommonResult.failed(ResultType.USER_CREDENTIALS_ERROR);
        } else if (e instanceof CredentialsExpiredException){
            result = CommonResult.failed(ResultType.USER_CREDENTIALS_ERROR);
        } else if (e instanceof DisabledException){
            result = CommonResult.failed(ResultType.USER_ACCOUNT_DISABLE);
        } else if (e instanceof LockedException){
            result = CommonResult.failed(ResultType.USER_ACCOUNT_LOCKED);
        } else if (e instanceof InternalAuthenticationServiceException){
            result = CommonResult.failed(ResultType.USER_ACCOUNT_NOT_EXIST);
        } else {
            result = CommonResult.failed(ResultType.COMMON_FAIL);
        }

        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(result));
    }
}
