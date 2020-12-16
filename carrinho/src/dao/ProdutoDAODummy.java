/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Produto;

/**
 *
 * @author ngoncalves
 */
public class ProdutoDAODummy extends ProdutoDAO {

    private static ProdutoDAODummy dao; //singleton
    private int seqProd = 1;
    private List<Produto> lista; //armazena num array para testes sem banco de dados
    
    
    private ProdutoDAODummy() {
        lista = new ArrayList<>();
    }
    
    public static ProdutoDAODummy getInstance() {
        if (dao == null) {
            dao = new ProdutoDAODummy();
        }
        return dao;
    }
    
    @Override
     public void cadastrar(Produto produto) throws ClassNotFoundException, SQLException {
         produto.setId(seqProd++);
         lista.add(produto);
    }
    
    @Override
    public List<Produto> consultarTodos() throws ClassNotFoundException, SQLException {

        return lista;
    }
    
    @Override
    public Produto consultarPorId(Produto produto) throws ClassNotFoundException, SQLException {
        
        Produto p = lista.get( lista.indexOf(produto) );
        
        return p;
    }

    @Override
    public void excluir(Produto produto) throws ClassNotFoundException, SQLException {
        
        lista.remove(produto);
    }

    @Override
    public void alterar(Produto produto) throws ClassNotFoundException, SQLException {
        
        produto.setImagem(((Produto) lista.get( lista.indexOf(produto) )).getImagem());
        lista.set( lista.indexOf(produto), produto );
        
    }
}