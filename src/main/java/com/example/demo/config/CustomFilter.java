package com.example.demo.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Klasa filter w niej mamy okreslone endpointy pod ktore wysylajac request nie wymagamy posiadania sesji ( uzykownik nie musi byc zalogowany )

@WebFilter("/*")
public class CustomFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String session = (String) req.getSession().getAttribute("email");
        String requestUri = req.getRequestURI();

        if (requestUri.endsWith("/")) {
            resp.sendRedirect(resp.encodeRedirectURL("home"));
        } else if (
                session != null ||
                        requestUri.endsWith(".css") ||
                        requestUri.endsWith(".jpg") ||
                        requestUri.endsWith(".png") ||
                        requestUri.endsWith("bootstrap.min.js") ||
                        requestUri.endsWith("login") ||
                        requestUri.endsWith("register") ||
                        requestUri.endsWith("home") ||
                        requestUri.endsWith("orderVisit")

        ) {
            filterChain.doFilter(req, resp);
        } else {
            resp.sendRedirect(resp.encodeRedirectURL("login"));
        }
    }

    @Override
    public void destroy() {

    }
}
