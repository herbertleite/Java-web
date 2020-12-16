package controle;

import dao.FabricaDAO;
import static dao.FabricaDAO.DAO;
import util.ImageUploader;
import dao.ProdutoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Especificacao;
import modelo.Produto;

/**
 *
 * @author ngoncalves
 */
@MultipartConfig
@WebServlet(name = "ProdutoControle", urlPatterns = {"/cadastrarproduto", "/alterarproduto", "/excluirproduto", "/listarprodutos", "/consultarprodutoid", "/index.html"})
public class ProdutoControle extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();

        if (url.equals(request.getContextPath() + "/cadastrarproduto")) {
            cadastrar(request, response);
        } else if (url.equals(request.getContextPath() + "/alterarproduto")) {
            alterar(request, response);
        } else {
            response.sendError(404, "Página não encontrada");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();

        try {
            
            if (url.equals(request.getContextPath() + "/excluirproduto")) {
                excluir(request, response);
            } else if (url.equals(request.getContextPath() + "/consultarprodutoid")) {
                consultarPorId(request, response);
            } else if (url.equals(request.getContextPath() + "/alterarproduto")) {
                consultarParaEdicao(request, response);
            } else {
                listarTodos(request, response);
            }
        
        } catch (Exception ex) {
            Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
            response.sendError(500, "Não foi possível completar a operação");
        }
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Produto prod = new Produto();  //monta o objeto produto
            prod.setDescricao(request.getParameter("descricao"));
            prod.setPreco(Double.parseDouble(request.getParameter("preco")));
            prod.setImagem(new ImageUploader().uploadImagem(request));
            
            Especificacao esp = new Especificacao(); //monta o objeto especificação
            esp.setCor(request.getParameter("cor"));
            esp.setMarca(request.getParameter("marca"));
            esp.setModelo(request.getParameter("modelo"));
            prod.setEspecificacao(esp); //agregação

            ProdutoDAO dao = (ProdutoDAO) FabricaDAO.getDAO(DAO.PRODUTO_DAO); //instancia a DAO
            dao.cadastrar(prod); //cadastra

            //listarTodos(request, response);
            request.setAttribute("produto", prod);
            request.getRequestDispatcher("produto.jsp").forward(request, response); //redireciona

        } catch (Exception ex) {
            Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
            response.sendError(500, "Não foi possível completar a operação");
        }
    }
    
    private void consultarParaEdicao(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        Produto produto = new Produto(id);
        ProdutoDAO dao = (ProdutoDAO) FabricaDAO.getDAO(DAO.PRODUTO_DAO);
        produto = dao.consultarPorId(produto);
        
        request.setAttribute("produto", produto);
        request.getRequestDispatcher("produtocadastro.jsp").forward(request, response);
    }
    
    private void alterar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Produto prod = new Produto();
            prod.setId(Integer.parseInt(request.getParameter("id")));
            prod.setDescricao(request.getParameter("descricao"));
            prod.setPreco(Double.parseDouble(request.getParameter("preco")));
            
            Especificacao esp = new Especificacao();
            esp.setCor(request.getParameter("cor"));
            esp.setMarca(request.getParameter("marca"));
            esp.setModelo(request.getParameter("modelo"));
            prod.setEspecificacao(esp);

            ProdutoDAO dao = (ProdutoDAO) FabricaDAO.getDAO(DAO.PRODUTO_DAO);
            dao.alterar(prod);

            request.setAttribute("produto", prod);
            request.getRequestDispatcher("produto.jsp").forward(request, response);

        } catch (Exception ex) {
            Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
            response.sendError(500, "Não foi possível completar a operação");
        }
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        Produto produto = new Produto(id);
        ProdutoDAO dao = (ProdutoDAO) FabricaDAO.getDAO(DAO.PRODUTO_DAO);
        dao.excluir(produto);

        listarTodos(request, response);
    }

    private void consultarPorId(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        Produto produto = new Produto(id);
        ProdutoDAO dao = (ProdutoDAO) FabricaDAO.getDAO(DAO.PRODUTO_DAO);
        produto = dao.consultarPorId(produto);
        
        request.setAttribute("produto", produto);
        request.getRequestDispatcher("produto.jsp").forward(request, response);
    }

    private void listarTodos(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {

        ProdutoDAO dao = (ProdutoDAO) FabricaDAO.getDAO(DAO.PRODUTO_DAO);
        List<Produto> listaProdutos = dao.consultarTodos();
        
        request.setAttribute("listaProdutos", listaProdutos);
        request.getRequestDispatcher("produtos.jsp").forward(request, response);
    }

}
