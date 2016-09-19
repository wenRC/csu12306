package com.csu.filter;

import com.sun.deploy.net.HttpRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by sx on 2016/9/19.
 */
@WebFilter(filterName = "PriorityFilter",urlPatterns = {"/to"})
public class PriorityFilter implements Filter {
    private static final String houTaiLoginUrl = "WEB-INF/jsp/houTaiLogin/houTaiLogin.jsp";
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest)servletRequest).getSession();
        String adminName = (String) session.getAttribute("adminName");
        String adminPassword = (String) session.getAttribute("adminPassword");
        if (!"admin".equals(adminName) || !"123".equals(adminPassword)) {
            servletRequest.getRequestDispatcher(houTaiLoginUrl).forward(servletRequest,servletResponse);
        } else {
            filterChain.doFilter(servletRequest,servletResponse);//继续执行
        }
    }
}
