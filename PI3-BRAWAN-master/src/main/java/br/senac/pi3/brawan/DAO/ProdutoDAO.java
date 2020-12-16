package br.senac.pi3.brawan.DAO;

import br.senac.pi3.brawan.model.Produto;
import br.senac.pi3.brawan.utils.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Guto
 */
public class ProdutoDAO {

    // Chamando a conexao com o banco de dados
    Connection connection = ConnectionUtils.getConnection();

    //Metodo que insere no banco de dados
    public void inserir(Produto produto) {

        try {

            String SQL = "INSERT INTO PRODUTO (nome, quantidade, categoria, "
                    + "marca, tamanho, vl_unitario, descricao, tg_status, codigo) VALUES "
                    + "(?,?,?,?,?,?,?,0,?)";

            PreparedStatement ps = connection.prepareStatement(SQL);

            ps.setString(1, produto.getNome());
            ps.setInt(2, produto.getQuantidade());
            ps.setString(3, produto.getCategoria());
            ps.setString(4, produto.getMarca());
            ps.setString(5, produto.getTamanho());
            ps.setString(6, produto.getValorUnitario());
            ps.setString(7, produto.getDescricao());
            ps.setString(8, produto.getCodigo());
            

            ps.execute();
            ps.close();
            connection.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    //Metodo que lista todos os dados do banco de dados
    public ArrayList<Produto> listarTudo() {
        String SQL = "SELECT * FROM PRODUTO WHERE TG_STATUS = 0";
        ArrayList<Produto> lista = new ArrayList<Produto>();
        try {

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                
                Produto produto = new Produto();
                
                produto.setCodigo(rs.getString("CODIGO"));
                produto.setNome(rs.getString("NOME"));
                produto.setQuantidade(rs.getInt("QUANTIDADE"));
                produto.setCategoria(rs.getString("CATEGORIA"));
                produto.setMarca(rs.getString("MARCA"));
                produto.setTamanho(rs.getString("TAMANHO"));
                produto.setValorUnitario(rs.getString("VL_UNITARIO"));

                lista.add(produto);

            }

            st.close();
            connection.close();
            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;

    }

   //Metodo que lista determinado elemento do banco de dados
    public ArrayList<Produto> listarCod(String cod) {
        String SQL = "SELECT * FROM PRODUTO WHERE CODIGO = " + cod +" AND TG_STATUS=0";
        ArrayList<Produto> lista = new ArrayList<Produto>();
        try {

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setCodigo(rs.getString("CODIGO"));
                produto.setNome(rs.getString("NOME"));
                produto.setQuantidade(rs.getInt("QUANTIDADE"));
                produto.setCategoria(rs.getString("CATEGORIA"));
                produto.setMarca(rs.getString("MARCA"));
                produto.setTamanho(rs.getString("TAMANHO"));
                produto.setValorUnitario(rs.getString("VL_UNITARIO"));
                produto.setDescricao(rs.getString("DESCRICAO"));

                lista.add(produto);
            }

            st.close();
            connection.close();
            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
   
    //Metodo que seta 0 para TG_STATUS, inativando logicamente
    public void inativar(Produto produto)
            throws SQLException, Exception {
        try {
            String sql = "UPDATE PRODUTO SET TG_STATUS =1 WHERE CODIGO = ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, produto.getCodigo());

            pst.execute();
            pst.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    
    //Metodo que edita o elemento do banco de dados
    public void editar(Produto produto) {

        try {

            String SQL = "UPDATE PRODUTO SET NOME=?, QUANTIDADE=?, CATEGORIA=?,MARCA=?,"
                    + " TAMANHO=?, VL_UNITARIO=?, DESCRICAO=? WHERE CODIGO=?"; 

            PreparedStatement ps = connection.prepareStatement(SQL);

            ps.setString(1, produto.getNome());
            ps.setInt(2, produto.getQuantidade());
            ps.setString(3, produto.getCategoria());
            ps.setString(4, produto.getMarca());
            ps.setString(5, produto.getTamanho());
            ps.setString(6, produto.getValorUnitario());
            ps.setString(7, produto.getDescricao());
            ps.setString(8, produto.getCodigo());

            ps.execute();
            ps.close();
            connection.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
