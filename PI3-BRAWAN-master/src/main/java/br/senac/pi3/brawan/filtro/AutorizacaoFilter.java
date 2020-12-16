package br.senac.pi3.brawan.filtro;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebFilter(filterName = "AutorizacaoFilter",
        servletNames = {"ClienteServlet", "EmpresaServlet", "FuncionarioServlet",
            "ProdutoServlet", "RelatorioServlet", "VendaServlet"})
public class AutorizacaoFilter implements Filter {
    

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        // CAST para objetos do tipo HttpServlet*
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Verifica se usuario ja esta logado
        HttpSession sessao = httpRequest.getSession();
        
        if (sessao.getAttribute("usuario") == null) {
            // Redirecionar para tela de login
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
            return;
            
        }else{
             chain.doFilter(request, response);
        }

       

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {
    }

}
