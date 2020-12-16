package controle;

import dao.FabricaDAO;
import dao.ProdutoDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Carrinho;
import modelo.Produto;

/**
 *
 * @author ngoncalves
 */
@WebServlet(name = "CarrinhoControle", urlPatterns = {"/carrinho", "/adicionarNoCarrinho", "/removerDoCarrinho"})
public class CarrinhoControle extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI();

        if (url.equals(request.getContextPath() + "/adicionarNoCarrinho")) {
            colocarNoCarrinho(request, response);
        } else if (url.equals(request.getContextPath() + "/removerDoCarrinho")) {
            removerDoCarrinho(request, response);
        } else {
            consultarCarrinho(request, response);
        }
    }

    private void colocarNoCarrinho(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id")); //id passado para a servlet
            Produto produtoAAdicionar = new Produto();
            produtoAAdicionar.setId(id);
            
            ProdutoDAO dao = (ProdutoDAO) FabricaDAO.getDAO(FabricaDAO.DAO.PRODUTO_DAO);
            produtoAAdicionar = dao.consultarPorId(produtoAAdicionar); //recupera do banco
            
            Carrinho carrinho = (Carrinho) request.getSession(true).getAttribute("carrinho");
            
            if (carrinho== null){ //Se ainda não houve carrinho na sessão, cria o objeto
                carrinho = new Carrinho();
                request.getSession().setAttribute("carrinho", carrinho);
            }
            carrinho.addProduto(produtoAAdicionar);
            response.sendRedirect("carrinho.jsp");
        
        } catch (Exception ex) {
            Logger.getLogger(CarrinhoControle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void removerDoCarrinho(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Produto produtoARemover = new Produto();
            produtoARemover.setId(id);

            ProdutoDAO dao = (ProdutoDAO) FabricaDAO.getDAO(FabricaDAO.DAO.PRODUTO_DAO);
            produtoARemover = dao.consultarPorId(produtoARemover);

            Carrinho carrinho = (Carrinho) request.getSession().getAttribute("carrinho");
            carrinho.remover(produtoARemover);

            response.sendRedirect("carrinho.jsp");
        
        } catch (Exception ex) {
            try {
                Logger.getLogger(CarrinhoControle.class.getName()).log(Level.SEVERE, null, ex);
                response.sendError(500, "Não foi possível remover o produto do carrinho.");
            } catch (IOException ex1) {
                Logger.getLogger(CarrinhoControle.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    private void consultarCarrinho(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("carrinho.jsp");
        } catch (IOException ex) {
            Logger.getLogger(CarrinhoControle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
