package org.example.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/name"})
@Log4j2
public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        log.info("Filter获取到请求地址：" + httpServletRequest.getServletPath());
        filterChain.doFilter(request, response);
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        log.info("Filter获取到响应类型：" + httpServletResponse.getContentType());
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter随着项目的启动而启动，只初始化一次");
    }

    @Override
    public void destroy() {
        System.out.println("Filter随着web项目的停止而销毁，完成资源回收");
    }
}
