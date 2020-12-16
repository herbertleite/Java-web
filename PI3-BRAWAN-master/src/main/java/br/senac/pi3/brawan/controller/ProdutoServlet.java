package br.senac.pi3.brawan.controller;

import br.senac.pi3.brawan.DAO.ProdutoDAO;
import br.senac.pi3.brawan.model.Produto;
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
@WebServlet(name = "ProdutoServlet", urlPatterns = {"/CadastrarProduto",
    "/ConsultarProduto", "/ConsultarProdutoID", "/ProdutoInativar",
    "/ProdutoEditar01", "/ProdutoEditar02"})
public class ProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String pagina = request.getRequestURI();

        try {
            if (pagina.endsWith("ConsultarProduto")) {
                produtoConsultar(request, response);
            } else if (pagina.endsWith("ConsultarProdutoID")) {
                produtoConsultarId(request, response);
            } else if (pagina.endsWith("ProdutoInativar")) {
                produtoInativar(request, response);
            } else if (pagina.endsWith("ProdutoEditar01")) {
                produtoEditar01(request, response);
            }
        } catch (IOException | ServletException ex) {
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
            if (pagina.endsWith("CadastrarProduto")) {
                produtoSalvar(request, response);
            } else if (pagina.endsWith("ProdutoEditar02")) {
                produtoEditar02(request, response);

            }
        } catch (IOException | ServletException ex) {
            throw new ServletException(ex.getMessage());
        }

    }

    protected void produtoSalvar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String codigo = request.getParameter("codigo");
        String nome = request.getParameter("nome");
        String quantidade = request.getParameter("quantidade");
        String categoria = request.getParameter("categoriaProduto");
        String marca = request.getParameter("marcaProduto");
        String tamanho = request.getParameter("tamanhoProduto");
        String valorUnitario = request.getParameter("valor");
        String descricao = request.getParameter("comentario");

        Produto produto = new Produto();

        produto.setCodigo(codigo);
        produto.setNome(nome);
        produto.setQuantidade(Integer.parseInt(quantidade));
        produto.setCategoria(categoria);
        produto.setMarca(marca);
        produto.setTamanho(tamanho);
        produto.setValorUnitario(valorUnitario);
        produto.setDescricao(descricao);

        ProdutoDAO dao = new ProdutoDAO();
        dao.inserir(produto);
        request.setAttribute("msgSucess", "Produto cadastrado com sucesso no Sistema!");
        request.getRequestDispatcher("./jsp/produto/cadastroProduto.jsp")
                .forward(request, response);

    }

    protected void produtoConsultar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProdutoDAO dao = new ProdutoDAO();
        ArrayList<Produto> pro = dao.listarTudo();

        RequestDispatcher rd = request.getRequestDispatcher("./jsp/produto/consultarProduto.jsp");
        request.setAttribute("produto", pro);
        rd.forward(request, response);

    }

    protected void produtoConsultarId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cod = request.getParameter("Codbusca");

        if (cod.isEmpty() || cod == null || cod == "") {
            response.sendRedirect("./ConsultarProduto");

        } else {

            ProdutoDAO dao = new ProdutoDAO();

            ArrayList<Produto> pro = dao.listarCod(cod);

            RequestDispatcher rd = request.getRequestDispatcher("./jsp/produto/consultarProdutoID.jsp");
            request.setAttribute("produto", pro);
            rd.forward(request, response);
        }
    }

    protected void produtoInativar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String cod = request.getParameter("cod");

            Produto produto = new Produto();
            produto.setCodigo(cod);
            ProdutoDAO dao = new ProdutoDAO();
            dao.inativar(produto);
            request.setAttribute("msgDelete", "Produto Excluido com sucesso!");
            request.getRequestDispatcher("./ConsultarProduto")
                    .forward(request, response);

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    protected void produtoEditar01(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cod = request.getParameter("cod");

        ProdutoDAO dao = new ProdutoDAO();

        ArrayList<Produto> pro = dao.listarCod(cod);

        RequestDispatcher rd = request.getRequestDispatcher("./jsp/produto/editarProduto.jsp");
        request.setAttribute("produto", pro);
        rd.forward(request, response);

    }

    protected void produtoEditar02(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cod = request.getParameter("cod");
        String nome = request.getParameter("nome");
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        String categoria = request.getParameter("categoriaProduto");
        String marca = request.getParameter("marcaProduto");
        String tamanho = request.getParameter("tamanhoProduto");
        String valorUnitario = request.getParameter("valor");
        String descricao = request.getParameter("comentario");

        Produto produto = new Produto();
        produto.setCodigo(cod);
        produto.setNome(nome);
        produto.setQuantidade(quantidade);
        produto.setCategoria(categoria);
        produto.setMarca(marca);
        produto.setTamanho(tamanho);
        produto.setValorUnitario(valorUnitario);
        produto.setDescricao(descricao);

        ProdutoDAO dao = new ProdutoDAO();

        dao.editar(produto);

        response.sendRedirect("./ConsultarProduto");

    }

}
