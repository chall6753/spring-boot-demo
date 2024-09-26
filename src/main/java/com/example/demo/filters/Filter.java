package com.example.demo.filters;

import com.example.demo.WelcomeMessage;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;
import org.slf4j.MDC;
import java.io.IOException;
import org.springframework.stereotype.Component;

@Component
public class Filter extends OncePerRequestFilter {
    Logger log = LoggerFactory.getLogger(WelcomeMessage.class);
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Add custom logic before passing the request along the filter chain
        System.out.println("Processing request: " + request.getRequestURI());
        MDC.put("tid", request.getHeader("x-transaction-id"));
        log.info("Processing request: {}", request.getRequestURI());

        // Pass the request along the filter chain
        filterChain.doFilter(request, response);

        // Add custom logic after the request has been processed

        log.info("Response status: {}", response.getStatus());
    }
}
