package com.fh.util;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @FileName: CrossFilter
 * @Author: <a href="dongchangan@uming.net">dongchang'an</a>.
 * @CreateTime: 2016/5/23 13:37
 * @Version: v1.0
 * @description: 跨域处理类
 */
public class CrossFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.addHeader("Access-Control-Allow-Headers", "x-requested-with, Authorization, Content-Type");
        response.addHeader("Access-Control-Max-Age", "1800");// 30 min
        filterChain.doFilter(request, response);
    }
}
