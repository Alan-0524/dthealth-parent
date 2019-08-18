package com.dthealth.safe.config;

import com.dthealth.dao.service.RedisService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserInfoAuthentication extends UsernamePasswordAuthenticationFilter {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private RedisService redisService;
    private AuthenticationManager authenticationManager;

    public UserInfoAuthentication(AuthenticationManager authenticationManager, RedisService redisService) {
        this.authenticationManager = authenticationManager;
        this.redisService = redisService;
        super.setFilterProcessesUrl("/do-sign-in");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());
        }

        String username = request.getParameter("userAccount");
        String password = request.getParameter("password");

        if (username == null) {
            username = "";
        }

        if (password == null) {
            password = "";
        }

        username = username.trim();

        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                username, password);

        // Allow subclasses to set the "details" property
        setDetails(request, authRequest);

        return authenticationManager.authenticate(authRequest);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        SecureUser secureUser = (SecureUser) authResult.getPrincipal();
        String userAccount = secureUser.getUsername();
        GrantedAuthority role = (GrantedAuthority) secureUser.getAuthorities().toArray()[0];
        String roleCode = role.getAuthority();
        String token = "";
        try {
            token = redisService.storeToken(userAccount, roleCode, 3600L);
        } catch (JsonProcessingException je) {
            logger.error("JsonProcessingException: {}", je.getMessage());
        } catch (Exception e) {
            logger.error("Exception: {}", e.getMessage());
        }
        Cookie cookie = new Cookie("dthealth-token", token);
        cookie.setMaxAge(60 * 60);
        response.addCookie(cookie);
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("text/html;charset=UTF-8");
        response.sendRedirect("http://localhost:8080/home");
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request,
                                              HttpServletResponse response, AuthenticationException failed)
            throws IOException, ServletException {
        response.getWriter().write("authentication failed, reason: " + failed.getMessage());
    }
}
