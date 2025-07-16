package br.com.gerenciadortasksjava.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter({"*"})
public class AutenticacaoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) { }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String path = httpServletRequest.getRequestURI().substring(httpServletRequest.getContextPath().length());

        if (path.equals("/pages/jsp/cadastro.jsp") 
        || path.equals("/criarusuario") 
        || path.startsWith("/console") 
        || path.startsWith("/h2-console")
        || path.equals("/pages/jsp/login.jsp")
        || path.startsWith("/login")
        || path.startsWith("/favicon")) {
            chain.doFilter(servletRequest, servletResponse);
            return;
        }

        if (isUsuarioLogado(httpServletRequest)) {
            if (httpServletRequest.getAttribute("message") == null) {
                servletRequest.setAttribute("message", "Usuário não autenticado");
            }
            servletRequest.getRequestDispatcher("/pages/jsp/login.jsp").forward(httpServletRequest, servletResponse);
        } else {
            chain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() { }

    private boolean isUsuarioLogado(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getSession().getAttribute("usuariologado") == null;
    }
}
