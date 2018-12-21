package com.test.auth;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author anonymity
 */
@Component
public class JwtTokenFilter implements Filter {

    @Resource
    private JwtService jwtService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        String authorization = servletRequest.getHeader("Authorization");
        if (authorization != null && authorization.startsWith("Bearer ")) {
            jwtService
                    .parse(authorization.replaceAll("Bearer ", ""))
                    .ifPresent(jwtAuthentication -> SecurityContextHolder
                            .getContext()
                            .setAuthentication(jwtAuthentication));
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
