package br.senac.pi3.brawan.controller;

import br.senac.pi3.brawan.DAO.EmpresaDAO;
import br.senac.pi3.brawan.model.Empresa;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Guto
 */
@WebServlet(name = "EmpresaServlet", urlPatterns = {"/CadastrarEmpresa", "/EmpresaEditar01",
    "/EmpresaInativar", "/ConsultarEmpresa", "/EditarEmpresa02"})
public class EmpresaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String pagina = request.getRequestURI();

        try {
            if (pagina.endsWith("EmpresaEditar01")) {
                empresaEditar01(request, response);
            }else if(pagina.endsWith("EmpresaInativar")){
                empresaInativar(request, response);
            }
            else if(pagina.endsWith("ConsultarEmpresa")){
                empresaConsultar(request, response);
            
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
            if (pagina.endsWith("CadastrarEmpresa")) {
                empresaSalvar(request, response);
            }else if (pagina.endsWith("EditarEmpresa02")) {
                empresaEditar02(request, response);
            }
        } catch (Exception ex) {
            throw new ServletException(ex.getMessage());
        }
    }

    protected void empresaSalvar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Pega os dados do parametros
        String empresaNome = request.getParameter("empresa");
        String diretor = request.getParameter("diretor");
        String cnpj = request.getParameter("cnpj");
        String endereco = request.getParameter("endereco");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String uf = request.getParameter("idEstado");
        String cep = request.getParameter("cep");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");

        //Monta o OBEJTO
        Empresa empresa = new Empresa();

        empresa.setEmpresa(empresaNome);
        empresa.setDiretor(diretor);
        empresa.setCnpj(cnpj);
        empresa.setEndereco(endereco);
        empresa.setBairro(bairro);
        empresa.setCidade(cidade);
        empresa.setUf(uf);
        empresa.setCep(cep);
        empresa.setTelefone(telefone);
        empresa.setEmail(email);

        EmpresaDAO dao = new EmpresaDAO();
        dao.inserir(empresa);
         request.setAttribute("msgSucess", "Filial cadastrada com sucesso no Sistema!");
        request.getRequestDispatcher("./jsp/empresa/cadastroEmpresa.jsp")
        .forward(request, response);
    }

    protected void empresaConsultar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        EmpresaDAO dao = new EmpresaDAO();

        ArrayList<Empresa> emp = dao.listarTudo();

        RequestDispatcher rd = request.getRequestDispatcher("./jsp/empresa/consultarEmpresa.jsp");
        request.setAttribute("empresa", emp);
        rd.forward(request, response);

    }

    protected void empresaEditar01(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        String req = request.getParameter("id");

        int id = Integer.parseInt(req);

        EmpresaDAO dao = new EmpresaDAO();

        ArrayList<Empresa> emp = dao.listarID(id);

        RequestDispatcher rd = request.getRequestDispatcher("./jsp/empresa/editarEmpresa.jsp");
        request.setAttribute("empresa", emp);
        rd.forward(request, response);
    }

    protected void empresaEditar02(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String empresaNome = request.getParameter("empresa");
        String diretor = request.getParameter("diretor");
        String cnpj = request.getParameter("cnpj");
        String endereco = request.getParameter("endereco");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String uf = request.getParameter("uf");
        String cep = request.getParameter("cep");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");

        Empresa empresa = new Empresa();
        empresa.setId(id);
        empresa.setEmpresa(empresaNome);
        empresa.setDiretor(diretor);
        empresa.setCnpj(cnpj);
        empresa.setEndereco(endereco);
        empresa.setBairro(bairro);
        empresa.setCidade(cidade);
        empresa.setUf(uf);
        empresa.setCep(cep);
        empresa.setTelefone(telefone);
        empresa.setEmail(email);

        EmpresaDAO dao = new EmpresaDAO();
        dao.Editar(empresa);
        response.sendRedirect("./ConsultarEmpresa");
    }

    protected void empresaInativar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        String req = request.getParameter("id");

        int id = Integer.parseInt(req);

        EmpresaDAO dao = new EmpresaDAO();
        Empresa empresa = new Empresa();

        empresa.setId(id);
        dao.inativar(empresa);
        request.setAttribute("msgDelete", "Filial Excluida com sucesso!");
        request.getRequestDispatcher("./ConsultarEmpresa")
        .forward(request, response);

    }
}


