package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ngoncalves
 */
public class Carrinho {
    
    private List<Produto> produtosNoCarrinho = new ArrayList<>();
    
    public void addProduto(Produto produto) {
        produtosNoCarrinho.add(produto);
    }
    
    public List<Produto> getProdutosNoCarrinho() {
        return produtosNoCarrinho;
    }

    public void remover(Produto produtoARemover) {
        produtosNoCarrinho.remove(produtoARemover);
    }

}
