package com.leewardassociates.input.validator.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.leewardassociates.input.validator.wrappers.XSSRequestWrapper;

/**
 * Here is a good and simple anti cross-site scripting (XSS) filter written for Java web applications. 
 * What it basically does is remove all suspicious strings from request parameters before returning them to the application. 
 * This code was compiled from an example posted in Java Code Geeks (http://www.javacodegeeks.com/2012/07/anti-cross-site-scripting-xss-filter.html)
 * @author Ricardo Zuasti
 */
public class XSSFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
	    FilterChain chain) throws IOException, ServletException {
	chain.doFilter(new XSSRequestWrapper((HttpServletRequest) request), response);
    }

    public void init(FilterConfig config) throws ServletException {
    }

}
