package com.du.rems.jwt.securityHandler;

import com.alibaba.fastjson.JSON;
import com.du.rems.response.CommonResult;
import com.du.rems.response.ResultType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author DU425
 * @Date 2022/2/6 17:53
 * @Version 1.0
 * @Description 权限拒绝处理逻辑 异常处理器，只负责其他请求抛出的异常
 */
@Component
public class CustomizeAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        CommonResult result = CommonResult.failed(ResultType.NO_PERMISSION);
        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(result));
    }
}
