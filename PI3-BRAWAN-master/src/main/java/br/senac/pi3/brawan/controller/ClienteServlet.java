package br.senac.pi3.brawan.controller;

import br.senac.pi3.brawan.DAO.ClienteDAO;
import br.senac.pi3.brawan.model.Pessoa;
import br.senac.pi3.brawan.service.validarCPF;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ClienteServlet", urlPatterns = {"/CadastrarCliente",
    "/ConsultarCliente", "/ConsultarClienteID", "/ClienteEditar01",
    "/EditarCliente02", "/ClienteInativar"})
public class ClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String pagina = request.getRequestURI();

        try {
            if (pagina.endsWith("ConsultarCliente")) {
                clienteConsultar(request, response);
            } else if (pagina.endsWith("ConsultarClienteID")) {
                clienteConsultarId(request, response);
            } else if (pagina.endsWith("ClienteEditar01")) {
                clienteEditar01(request, response);
            } else if (pagina.endsWith("ClienteInativar")) {
                clienteInativar(request, response);
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
            if (pagina.endsWith("CadastrarCliente")) {
                clienteSalvar(request, response);
            } else if (pagina.endsWith("EditarCliente02")) {
                clienteEditar02(request, response);
            }
        } catch (IOException | ServletException ex) {
            throw new ServletException(ex.getMessage());
        }
    }

    protected void clienteSalvar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
        
        
        if (validarCPF.isValidCPF(cpf)== false) {
            
        request.setAttribute("msgErro", "CPF Invalido!");
        request.getRequestDispatcher("./jsp/cliente/cadastroCliente.jsp")
        .forward(request, response);
            
        }

        //Monta o OBEJTO
        Pessoa cliente = new Pessoa();

        cliente.setNome(nome);
        cliente.setRg(rg);
        cliente.setCpf(cpf);
        cliente.setSexo(sexo);
        cliente.setTelefone(telefone);
        cliente.setEmail(email);
        cliente.setEndereco(endereco);
        cliente.setBairro(bairro);
        cliente.setCidade(cidade);
        cliente.setUf(estado);
        cliente.setCep(cep);

        ClienteDAO dao = new ClienteDAO();
        dao.inserir(cliente);
        
        request.setAttribute("msgSucess", "Cliente cadastrado com sucesso no Sistema!");
        request.getRequestDispatcher("./jsp/cliente/cadastroCliente.jsp")
        .forward(request, response);
      
    }

    protected void clienteConsultar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        ClienteDAO dao = new ClienteDAO();

        ArrayList<Pessoa> cli = dao.listarTudo();

        RequestDispatcher rd = request.getRequestDispatcher("./jsp/cliente/consultarCliente.jsp");
        request.setAttribute("cliente", cli);
        rd.forward(request, response);

    }

    protected void clienteConsultarId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        String req = request.getParameter("Codbusca");

        if (req.isEmpty() || req == null || req == "") {
            response.sendRedirect("./ConsultarCliente");

        } else {

            int id = Integer.parseInt(req);

            ClienteDAO dao = new ClienteDAO();

            ArrayList<Pessoa> cli = dao.listarID(id);

            RequestDispatcher rd = request.getRequestDispatcher("./jsp/cliente/consultarClienteID.jsp");
            request.setAttribute("cliente", cli);
            rd.forward(request, response);
        }
    }

    protected void clienteEditar01(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        String req = request.getParameter("id");

        int id = Integer.parseInt(req);

        ClienteDAO dao = new ClienteDAO();

        ArrayList<Pessoa> cli = dao.listarID(id);

        RequestDispatcher rd = request.getRequestDispatcher("./jsp/cliente/editarCliente.jsp");
        request.setAttribute("cliente", cli);
        rd.forward(request, response);
    }

    protected void clienteEditar02(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession(true);
        
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

        Pessoa cliente = new Pessoa();
        cliente.setId(id);
        cliente.setNome(nome);
        cliente.setRg(rg);
        cliente.setCpf(cpf);
        cliente.setSexo(sexo);
        cliente.setTelefone(telefone);
        cliente.setEmail(email);
        cliente.setEndereco(endereco);
        cliente.setBairro(bairro);
        cliente.setCidade(cidade);
        cliente.setUf(estado);
        cliente.setCep(cep);
                
        ClienteDAO dao = new ClienteDAO();
        dao.Editar(cliente);
        request.setAttribute("msgSucessEditado", "Cliente alterado com sucesso!");
        response.sendRedirect("./ConsultarCliente");
    }

    protected void clienteInativar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        String req = request.getParameter("id");

        int id = Integer.parseInt(req);
        
        ClienteDAO dao = new ClienteDAO();
        Pessoa cliente = new Pessoa();

        cliente.setId(id);
        dao.inativar(cliente);
        request.setAttribute("msgDelete", "Cliente Excluido com sucesso!");
        request.getRequestDispatcher("./ConsultarCliente")
        .forward(request, response);

    }
}
