package com.du.rems.jwt.securityHandler;

import com.alibaba.fastjson.JSON;
import com.du.rems.response.CommonResult;
import com.du.rems.response.ResultType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author DU425
 * @Date 2022/1/16 14:48
 * @Version 1.0
 * @Description: 匿名用户访问无权限资源时的异常
 */
@Component
public class CustomizeAuthenticationEntryPoint implements AuthenticationEntryPoint {

    /**
     * 未登录处理类
     * @param httpServletRequest
     * @param httpServletResponse
     * @param e
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        CommonResult result = CommonResult.failed(ResultType.USER_NOT_LOGIN);
        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(result));
    }
}
