package br.senac.pi3.brawan.controller;

import br.senac.pi3.brawan.DAO.EmpresaDAO;
import br.senac.pi3.brawan.DAO.RelatorioDAO;
import br.senac.pi3.brawan.model.Empresa;
import br.senac.pi3.brawan.model.Relatorio;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Guto
 */
@WebServlet(name = "RelatorioServlet", urlPatterns = {"/Relatorio", "/RelatorioInicio"})
public class RelatorioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String pagina = request.getRequestURI();

        try {
            if (pagina.endsWith("RelatorioInicio")) {
                relatorioInicio(request, response);
            } 
             
        } catch (Exception ex) {
            throw new ServletException(ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String pagina = request.getRequestURI();
        
        
        try {
            if (pagina.endsWith("Relatorio")) {
                relatorioFiltro(request, response);
            } 
           
        } catch (Exception ex) {
            throw new ServletException(ex.getMessage());
        }

    }
    
      protected void relatorioInicio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        HttpSession sessao = request.getSession(true);
          
        EmpresaDAO dao = new EmpresaDAO();

        ArrayList<Empresa> emp = dao.listarTudo();

        RequestDispatcher rd = request.getRequestDispatcher("./jsp/vendas/relatorio.jsp");
        sessao.setAttribute("empresa", emp);
        rd.forward(request, response);

    }
    
    
    protected void relatorioFiltro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sessao = request.getSession(true);
     
        try {
            DateFormat nova = new SimpleDateFormat("yyyy-MM-dd");
            
            String empresa = request.getParameter("empresa");
            String inicio = request.getParameter("dataInicio");
            String fim = request.getParameter("dataFinal");
            
         
            
            Date date = nova.parse(inicio);
            date = nova.parse(fim);
            
            RelatorioDAO relat = new RelatorioDAO();
            
            ArrayList<Relatorio> relatorio = relat.relatorios(inicio,fim, empresa);
            
            RequestDispatcher rd = request.getRequestDispatcher("./jsp/vendas/relatorio.jsp");
            sessao.setAttribute("relatorio", relatorio);
            rd.forward(request, response);
            
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
        
        
    }
}
