package filter;


import model.User;
import service.UserService;
import servlets.UserServlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/admin/*"})
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        User user = (User) req.getSession().getAttribute("user");
        req.setAttribute("user", user);
        if( user !=null) {
            if (user.getRole().equals("user")) {
                req.getRequestDispatcher("/user.jsp").forward(req, servletResponse);
            }
        }
        if(user.getRole().equals("admin")) {
            filterChain.doFilter(req, servletResponse);
        }


    }

    @Override
    public void destroy() {

    }
}
