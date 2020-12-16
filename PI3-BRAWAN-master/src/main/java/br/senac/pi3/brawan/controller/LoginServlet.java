package br.senac.pi3.brawan.controller;

import br.senac.pi3.brawan.DAO.LoginDAO;
import br.senac.pi3.brawan.model.Funcionario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");

        LoginDAO dao = new LoginDAO();
        Funcionario login = new Funcionario();
        login.setLogin(usuario);
        login.setSenha(senha);

        boolean retorno = dao.login(login);

        if (retorno == true) {
            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuario", usuario);
            response.sendRedirect("./jsp/home.jsp");

        } else {
            request.setAttribute("msgError", "Usuário ou Senha inválido!");
            response.sendRedirect("./login.jsp");

        }
    }

}
