package com.template.rest.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ServletFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if (request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
			HttpServletRequestWritableWrapper requestWrapper = new HttpServletRequestWritableWrapper((HttpServletRequest) request);
			HttpServletResponseReadableWrapper responseWrapper = new HttpServletResponseReadableWrapper((HttpServletResponse) response);
			chain.doFilter(requestWrapper, responseWrapper);
		}
	}

	@Override
	public void destroy() {
	}

}
