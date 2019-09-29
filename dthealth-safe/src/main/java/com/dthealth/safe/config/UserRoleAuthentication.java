package com.dthealth.safe.config;

import com.dthealth.dao.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.thymeleaf.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class UserRoleAuthentication extends BasicAuthenticationFilter {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    private RedisService redisService;
    protected FilterChain chain;

    public UserRoleAuthentication(AuthenticationManager authenticationManager, RedisService redisService) {
        super(authenticationManager);
        this.redisService = redisService;
    }

    public UserRoleAuthentication(AuthenticationManager authenticationManager, AuthenticationEntryPoint authenticationEntryPoint) {
        super(authenticationManager, authenticationEntryPoint);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        this.chain = chain;
        String token = "";
        Cookie[] cookies = request.getCookies();
        if (null == cookies) {
            chain.doFilter(request, response);
            return;
        }

        for (Cookie cookie : cookies) {
            if ("dthealth-token".equals(cookie.getName())) {
                token = cookie.getValue();
            }
        }
        String value = redisService.getBodyByKey(token);
        if (StringUtils.isEmpty(value)) {
            chain.doFilter(request, response);
            return;
        }
        String userAccount = value.split("-")[0];
        String role = value.split("-")[1];
        UsernamePasswordAuthenticationToken ua = new UsernamePasswordAuthenticationToken(userAccount, null, Collections.singleton(new SimpleGrantedAuthority(role)));
        SecurityContextHolder.getContext().setAuthentication(ua);
        super.doFilterInternal(request, response, chain);

    }
}
