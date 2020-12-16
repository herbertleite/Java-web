package br.senac.pi3.brawan.controller;

import br.senac.pi3.brawan.DAO.EmpresaDAO;
import br.senac.pi3.brawan.DAO.FuncionarioDAO;
import br.senac.pi3.brawan.model.Empresa;
import br.senac.pi3.brawan.model.Funcionario;
import br.senac.pi3.brawan.service.Criptografar;
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
@WebServlet(name = "FuncionarioServlet", urlPatterns = {"/Funcionario", "/CadastrarFuncionario",
    "/FuncionarioConsult", "/FuncionarioInativar", "/ConsultarFuncionarioId",
    "/FuncionarioEditar01", "/EditarFuncionario02"})
public class FuncionarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String pagina = request.getRequestURI();

        try {
            if (pagina.endsWith("Funcionario")) {
                funcionarioCadastro(request, response);
            } else if (pagina.endsWith("FuncionarioConsult")) {
                funcionarioConsultar(request, response);
            } else if (pagina.endsWith("FuncionarioInativar")) {
                funcionarioInativar(request, response);
            } else if (pagina.endsWith("ConsultarFuncionarioId")) {
                funcionarioConsultarID(request, response);
            } else if (pagina.endsWith("FuncionarioEditar01")) {
                funcionarioEditar01(request, response);
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
            if (pagina.endsWith("CadastrarFuncionario")) {
                funcionarioSalvar(request, response);
            } else if (pagina.endsWith("EditarFuncionario02")) {
                funcionarioEditar02(request, response);
            }
        } catch (IOException | ServletException ex) {
            throw new ServletException(ex.getMessage());
        }

    }

    protected void funcionarioCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        EmpresaDAO dao = new EmpresaDAO();

        ArrayList<Empresa> emp = dao.listarTudo();

        RequestDispatcher rd = request.getRequestDispatcher("./jsp/funcionario/cadastroFuncionario.jsp");
        request.setAttribute("empresa", emp);
        rd.forward(request, response);

    }

    protected void funcionarioSalvar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            //Pega os dados do parametros
            String nome = request.getParameter("nome");
            String rg = request.getParameter("rg");
            String cpf = request.getParameter("cpf");
            String sexo = request.getParameter("sexo");
            String telefone = request.getParameter("telefone");
            String email = request.getParameter("email");
            String endereco = request.getParameter("endereco");
            String bairro = request.getParameter("bairro");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("idEstado");
            String cep = request.getParameter("cep");
            String empresa = request.getParameter("empresa");
            String cargo = request.getParameter("cargo");
            String Usuario = request.getParameter("usuario");
            String senha = request.getParameter("senha");

            //Monta o OBEJTO
            Funcionario func = new Funcionario();

            func.setNome(nome);
            func.setRg(rg);
            func.setCpf(cpf);
            func.setSexo(sexo);
            func.setTelefone(telefone);
            func.setEmail(email);
            func.setEndereco(endereco);
            func.setBairro(bairro);
            func.setCidade(cidade);
            func.setUf(estado);
            func.setCep(cep);
            func.setEmpresa(empresa);
            func.setCargo(cargo);
            func.setLogin(Usuario);
            func.setSenha(Criptografar.criptografar(senha));

            FuncionarioDAO dao = new FuncionarioDAO();
            dao.inserir(func);

            request.setAttribute("msgSucess", "Funcionario cadastrado com sucesso no Sistema!");
            request.getRequestDispatcher("./jsp/funcionario/cadastroFuncionario.jsp")
                    .forward(request, response);

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    protected void funcionarioConsultar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        FuncionarioDAO dao = new FuncionarioDAO();

        ArrayList<Funcionario> fun = dao.listarTudo();

        RequestDispatcher rd = request.getRequestDispatcher("./jsp/funcionario/consultarFuncionario.jsp");
        request.setAttribute("funcionario", fun);
        rd.forward(request, response);

    }

    protected void funcionarioInativar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        String req = request.getParameter("id");

        int id = Integer.parseInt(req);

        FuncionarioDAO dao = new FuncionarioDAO();
        Funcionario func = new Funcionario();

        func.setId(id);
        dao.inativar(func);
        
        request.setAttribute("msgDelete", "Funcionario Excluido com sucesso!");
        request.getRequestDispatcher("./FuncionarioConsult")
        .forward(request, response);
    

    }

    protected void funcionarioConsultarID(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        String req = request.getParameter("Codbusca");

        if (req.isEmpty() || req == null || req == "") {
            response.sendRedirect("./FuncionarioConsult");

        } else {

            int id = Integer.parseInt(req);

            FuncionarioDAO dao = new FuncionarioDAO();

            ArrayList<Funcionario> fun = dao.listarID(id);

            RequestDispatcher rd = request.getRequestDispatcher("./jsp/funcionario/consultarFuncionarioID.jsp");
            request.setAttribute("funcionario", fun);
            rd.forward(request, response);

        }
    }

    protected void funcionarioEditar01(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        String req = request.getParameter("id");

        int id = Integer.parseInt(req);

        FuncionarioDAO dao = new FuncionarioDAO();
        EmpresaDAO dao2 = new EmpresaDAO();

        ArrayList<Funcionario> func = dao.listarID(id);
        ArrayList<Empresa> emp = dao2.listarTudo();

        RequestDispatcher rd = request.getRequestDispatcher("./jsp/funcionario/editarFuncionario.jsp");
        request.setAttribute("funcionario", func);
        request.setAttribute("empresa", emp);
        rd.forward(request, response);
    }

    protected void funcionarioEditar02(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String rg = request.getParameter("rg");
            String cpf = request.getParameter("cpf");
            String sexo = request.getParameter("sexo");
            String telefone = request.getParameter("telefone");
            String email = request.getParameter("email");
            String endereco = request.getParameter("endereco");
            String bairro = request.getParameter("bairro");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("idEstado");
            String cep = request.getParameter("cep");
            String empresa = request.getParameter("empresa");
            String cargo = request.getParameter("cargo");
            String Usuario = request.getParameter("usuario");
            String senha = request.getParameter("senha");

            Funcionario func = new Funcionario();

            func.setId(id);
            func.setNome(nome);
            func.setRg(rg);
            func.setCpf(cpf);
            func.setSexo(sexo);
            func.setTelefone(telefone);
            func.setEmail(email);
            func.setEndereco(endereco);
            func.setBairro(bairro);
            func.setCidade(cidade);
            func.setUf(estado);
            func.setCep(cep);
            func.setEmpresa(empresa);
            func.setCargo(cargo);
            func.setLogin(Usuario);
            func.setSenha(senha);

            FuncionarioDAO dao = new FuncionarioDAO();
            dao.editar(func);
            response.sendRedirect("./FuncionarioConsult");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
