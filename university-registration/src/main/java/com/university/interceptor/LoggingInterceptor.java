package com.university.interceptor;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoggingInterceptor implements HandlerInterceptor
{
    private static final Logger logger = Logger.getLogger(LoggingInterceptor.class.getName());

    public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception
    {
        String uri = request.getRequestURI();
        String method = request.getMethod();
        logger.info("Request: " + method + " " + uri);
        return true;
    }
}