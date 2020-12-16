/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Especificacao;
import modelo.Produto;

/**
 *
 * @author ngoncalves
 */
public class ProdutoDAO implements EntityDAO {

    public ProdutoDAO() {
    }
    
    /*
    create table produtos (
	id serial primary key,
	descricao varchar(50) not null, 
	preco varchar(50) not null
    );
    */
    
     public void cadastrar(Produto produto) throws ClassNotFoundException, SQLException {
        
        Connection con = FabricaConexao.getConexao();

        PreparedStatement comando = con.prepareStatement("insert into produtos (descricao, preco) values (?, ?) returning id");
        comando.setString(1, produto.getDescricao());
        comando.setDouble(2, produto.getPreco());
        ResultSet resultadoPK = comando.executeQuery();

        if (resultadoPK.next()) {
            produto.setId(resultadoPK.getInt("id"));
        }
        
        EspecificacaoDAO espDAO = (EspecificacaoDAO) FabricaDAO.getDAO(FabricaDAO.DAO.ESPECIFICACAO_DAO);
        espDAO.cadastrar(produto.getEspecificacao(), produto);
        con.close();
    }
    
    public List<Produto> consultarTodos() throws ClassNotFoundException, SQLException {
        
        Connection con = FabricaConexao.getConexao();

        PreparedStatement comando = con.prepareStatement("select id, descricao, preco from produtos");
        ResultSet resultado = comando.executeQuery();
        
        List<Produto> todosProdutos = new ArrayList<Produto>();
        while (resultado.next()) {
            Produto p = new Produto();
            p.setId(resultado.getInt("id"));
            p.setDescricao(resultado.getString("descricao"));
            p.setPreco(resultado.getDouble("preco"));
            todosProdutos.add(p);
        }
        con.close();
        return todosProdutos;
    }
    
    public Produto consultarPorId(Produto produto) throws ClassNotFoundException, SQLException {
        
        Connection con = FabricaConexao.getConexao();
        Produto p = null;

        PreparedStatement comando = con.prepareStatement("select id, descricao, preco from produtos where id=?");
        comando.setInt(1, produto.getId());
        ResultSet resultado = comando.executeQuery();
        
        if (resultado.next()) {
            p = new Produto();
            p.setId(resultado.getInt("id"));
            p.setDescricao(resultado.getString("descricao"));
            p.setPreco(resultado.getDouble("preco"));
            
            EspecificacaoDAO espDAO = (EspecificacaoDAO) FabricaDAO.getDAO(FabricaDAO.DAO.ESPECIFICACAO_DAO);
            Especificacao especificacao = espDAO.consultarPorProduto(p);
            p.setEspecificacao(especificacao);
        }
        
        con.close();
        
        return p;
    }

    public void excluir(Produto produto) throws ClassNotFoundException, SQLException {
        Connection con = FabricaConexao.getConexao();

        EspecificacaoDAO espDAO = (EspecificacaoDAO) FabricaDAO.getDAO(FabricaDAO.DAO.ESPECIFICACAO_DAO);
        produto.setEspecificacao(espDAO.consultarPorProduto(produto));
        espDAO.excluir(produto.getEspecificacao());
        
        PreparedStatement comando = con.prepareStatement("delete from produtos where id=?");
        comando.setInt(1, produto.getId());
        comando.execute();

        con.close();
    }

    public void alterar(Produto produto) throws ClassNotFoundException, SQLException {
        
        Connection con = FabricaConexao.getConexao();

        PreparedStatement comando = con.prepareStatement("update produtos set descricao = ?, preco=? where id=?");
        comando.setString(1, produto.getDescricao());
        comando.setDouble(2, produto.getPreco());
        comando.setInt(3, produto.getId());
        comando.execute();
        
        EspecificacaoDAO espDAO = (EspecificacaoDAO) FabricaDAO.getDAO(FabricaDAO.DAO.ESPECIFICACAO_DAO);
        espDAO.alterar(produto.getEspecificacao());
        con.close();
    }
}