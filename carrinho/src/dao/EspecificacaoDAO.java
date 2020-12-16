package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Especificacao;
import modelo.Produto;

/**
 *
 * @author ngoncalves
 */
public class EspecificacaoDAO implements EntityDAO {
    
    /*
    create table especificacoes (
	id serial primary key,
	marca varchar(50) not null,
	modelo varchar(50) not null, 
	cor varchar(50) not null,
	produtos_id integer references produtos(id)
    );
    */

    public void cadastrar(Especificacao especificacao, Produto produto) throws ClassNotFoundException, SQLException {
        Connection con = FabricaConexao.getConexao();

        PreparedStatement comando = con.prepareStatement("insert into especificacoes (marca, modelo, cor, produtos_id) values (?, ?, ?, ?)");
        comando.setString(1, especificacao.getMarca());
        comando.setString(2, especificacao.getModelo());
        comando.setString(3, especificacao.getCor());
        comando.setInt(4, produto.getId());
        comando.execute();

        con.close();
    }
    
    public Especificacao consultarPorProduto(Produto produto) throws ClassNotFoundException, SQLException {
        Connection con = FabricaConexao.getConexao();
        Especificacao e = null;

        PreparedStatement comando = con.prepareStatement("select id, marca, modelo, cor from especificacoes where produtos_id=?");
        comando.setInt(1, produto.getId());
        ResultSet resultado = comando.executeQuery();
        
        if (resultado.next()) {
            e = new Especificacao();
            e.setId(resultado.getInt("id"));
            e.setCor(resultado.getString("cor"));
            e.setMarca(resultado.getString("marca"));
            e.setModelo(resultado.getString("modelo"));
        }
        con.close();
        return e;
    }

    public void excluir(Especificacao especificacao) throws ClassNotFoundException, SQLException {
        Connection con = FabricaConexao.getConexao();
        
        PreparedStatement comando = con.prepareStatement("delete from especificacoes where id=?");
        comando.setInt(1, especificacao.getId());
        comando.execute();

        con.close();
    }

    public void alterar(Especificacao especificacao) throws ClassNotFoundException, SQLException {
        Connection con = FabricaConexao.getConexao();

        PreparedStatement comando = con.prepareStatement("update especificacoes set marca=?, modelo=?, cor=? where id=?");
        comando.setString(1, especificacao.getMarca());
        comando.setString(2, especificacao.getModelo());
        comando.setString(3, especificacao.getCor());
        comando.setInt(4, especificacao.getId());
        comando.execute();

        con.close();
    }
}
