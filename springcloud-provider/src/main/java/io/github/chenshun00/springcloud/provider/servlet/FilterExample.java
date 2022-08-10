package io.github.chenshun00.springcloud.provider.servlet;

import io.github.chenshun00.springcloud.provider.util.TraceUtil;

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
        try {
            TraceUtil.clear();
            //如果一定要用get，那么必须要先clear，原因是因为inThreadLocal的原因
            //thread会继承main线程中inTthreadLocal的数据，所以如果不先clear，那么这里会现有数据
            TraceUtil.get();
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            TraceUtil.clear();
        }
    }
}
