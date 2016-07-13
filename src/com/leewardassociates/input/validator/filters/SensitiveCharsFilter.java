package com.leewardassociates.input.validator.filters;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.leewardassociates.input.validator.util.InputValidator;
import com.leewardassociates.input.validator.wrappers.CharResponseWrapper;

public class SensitiveCharsFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		CharResponseWrapper wrapper = new CharResponseWrapper((HttpServletResponse) response);
		chain.doFilter(request, wrapper);
		CharArrayWriter caw = new CharArrayWriter();
		caw.write(InputValidator.filter(wrapper.toString()));
		response.setContentType("text/html");
		response.setContentLength(caw.toString().length());
		out.write(caw.toString());
		out.close();
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
