package com.dthealth.safe.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationResultHandle implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("application/json; charset=utf-8");
//        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//        String reason = "Problem："+authException.getMessage();
//        response.getWriter().write(new ObjectMapper().writeValueAsString(reason));

        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.getWriter().write("User information has expired. Please sign in again");
        response.sendRedirect("http://localhost:8080/to-sign-in");
        response.setContentType("text/html;charset=UTF-8");
    }
}
