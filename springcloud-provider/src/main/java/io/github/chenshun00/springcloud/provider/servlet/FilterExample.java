package io.github.chenshun00.springcloud.provider.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * <a href="https://www.yuque.com/chenshun00/sbny2o/sryzrb">SpringBoot and Servlet</a>
 *
 * @author chenshun00@gmail.com
 * @since 2022/4/28 10:43 AM
 */
@WebFilter(urlPatterns = "/*")
public class FilterExample implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
