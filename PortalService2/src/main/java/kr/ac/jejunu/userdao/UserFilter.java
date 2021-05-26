package kr.ac.jejunu.userdao;

import javax.servlet.*;
import java.io.IOException;

public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("************filter init******************");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("************filter before******************");
        chain.doFilter(request, response);
        System.out.println("************filter after******************");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        System.out.println("************filter destroy******************");

    }
}
