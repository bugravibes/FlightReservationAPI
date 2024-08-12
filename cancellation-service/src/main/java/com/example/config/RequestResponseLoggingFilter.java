package com.example.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RequestResponseLoggingFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        logger.info("Request: method={}, uri={}", req.getMethod(), req.getRequestURI());
        logger.info("Request headers: {}", req.getHeaderNames());
        logger.info("Request parameters: {}", req.getParameterMap());

        chain.doFilter(request, response);

        logger.info("Response: status={}, content-type={}", res.getStatus(), res.getContentType());
    }

    @Override
    public void destroy() {
    }
}

