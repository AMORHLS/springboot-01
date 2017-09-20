package com.hls.springboot.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


@WebFilter(filterName = "RoadFileter",urlPatterns = "/*")
public class RoadFilter implements Filter{
    private Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info(">>>>>>>>>>>RoadFilter.init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        logger.info(">>>>>>>>>>>RoadFilter.doFilter");
        chain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        logger.info(">>>>>>>>>>>RoadFilter.destroy");
    }
}
