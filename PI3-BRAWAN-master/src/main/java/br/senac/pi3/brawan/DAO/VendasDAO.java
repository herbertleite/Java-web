package br.senac.pi3.brawan.DAO;

import br.senac.pi3.brawan.model.Produto;
import br.senac.pi3.brawan.model.Venda;
import br.senac.pi3.brawan.utils.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VendasDAO {

    //Chamando a conexao com banco de dados
    Connection connection = ConnectionUtils.getConnection();

    //Selecionando determinado dado da tabela e adicionando em uma lista 
    public ArrayList<Produto> listarCod(String cod) {
        String SQL = "SELECT * FROM PRODUTO WHERE CODIGO = " + cod + " AND TG_STATUS=0";
        ArrayList<Produto> lista = new ArrayList<Produto>();
        try {

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("ID"));
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

    //Metodo que insere todos os itens vendidos no banco de dados
    public void inserirItemVenda(int cod, float soma) {

        try {

            String SQL = "INSERT INTO ITEMVENDA (FK_PRODUTO, DH_INCLUSAO, SOMA) VALUES "
                    + "(?,NOW(),?)";

            PreparedStatement ps = connection.prepareStatement(SQL);

            ps.setInt(1, cod);
            ps.setFloat(2, soma);

            ps.execute();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    //Metodo que adiciona a venda com todas as informacoes no banco de dados
    public void finalizarVenda(Venda venda, Object caixa, Object cpf) {

        try {

            Statement buscaCaixa = connection.createStatement();
            Statement buscaCliente = connection.createStatement();

            ResultSet resultado = buscaCaixa.executeQuery("SELECT FUN.ID, FUN.FK_EMPRESA FROM FUNCIONARIO AS FUN "
                    + "WHERE LOGIN LIKE '" + caixa + "%'");

            ResultSet resultado2 = buscaCliente.executeQuery("SELECT CLI.ID FROM CLIENTE AS CLI "
                    + "WHERE CPF LIKE '" + cpf + "%'");

            if (resultado != null && resultado.next()) {
                venda.setIdCaixa(resultado.getInt("FUN.ID"));
                venda.setEmpresa(resultado.getInt("FUN.FK_EMPRESA"));
            }

            if (resultado2 != null && resultado2.next()) {
                venda.setIdCliente(resultado2.getInt("CLI.ID"));
            }

            String SQL = "INSERT INTO FI_VENDA (FK_CLIENTE,FK_CAIXA,FK_EMPRESA, QUANTIDADE, DT_VENDA,VL_TOTAL,DH_INCLUSAO) VALUES "
                    + "(?,?,?,?,NOW(),?,NOW())";

            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setInt(1, venda.getIdCliente());
            ps.setInt(2, venda.getIdCaixa());
            ps.setInt(3, venda.getEmpresa());
            ps.setInt(4, venda.getQuantidade());
            ps.setFloat(5, venda.getValorTotal());
            ps.execute();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    //Metodo que busca o cliente no banco e retorna um Boolean
    public boolean buscarCliente(String cpf) {

        try {

            Statement buscaCliente = connection.createStatement();

            ResultSet resultado = buscaCliente.executeQuery("SELECT CLI.ID FROM CLIENTE AS CLI WHERE CPF LIKE '" + cpf + "%' AND TG_STATUS LIKE 0;");

            if (resultado != null && resultado.next()) {
                return true;

            } else {
                return false;
            }

        } catch (SQLException ex) {
            return false;

        }

    }

    //Metodo que busca produto no banco de dados e retorna um boolean
    public boolean buscarProduto(String cod) {

        try {

            Statement buscaProduto = connection.createStatement();

            ResultSet resultadoProduto = buscaProduto.executeQuery("SELECT PRO.ID FROM PRODUTO AS PRO WHERE CODIGO LIKE '" + cod + "%';");

            if (resultadoProduto != null && resultadoProduto.next()) {
                return true;

            } else {
                return false;
            }

        } catch (SQLException ex) {
            return false;

        }

    }

    //Metodo que atualiza o banco de dados quando uma venda é finalizada
    public void atualizarEstoque(int estoqueAtual, int idProduto) {

        try {

            String SQL = "UPDATE PRODUTO SET QUANTIDADE=? WHERE ID=?";

            PreparedStatement ps = connection.prepareStatement(SQL);

            ps.setInt(1, estoqueAtual);
            ps.setInt(2, idProduto);
            ps.execute();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
