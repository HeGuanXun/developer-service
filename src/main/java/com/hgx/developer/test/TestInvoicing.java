package com.hgx.developer.test;

import javax.servlet.*;
import java.io.IOException;

public class TestInvoicing implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter");
    }

    @Override
    public void destroy() {

    }
}
