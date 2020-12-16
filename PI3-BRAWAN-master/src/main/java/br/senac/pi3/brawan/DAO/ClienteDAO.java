 package br.senac.pi3.brawan.DAO;

import br.senac.pi3.brawan.utils.ConnectionUtils;
import br.senac.pi3.brawan.model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClienteDAO {

    //Chama a conexao com o banco de dados 
    Connection connection = ConnectionUtils.getConnection();

    
    //Método que insere cliente no banco de dados
    public void inserir(Pessoa cliente) {

        try {

            String SQL = "INSERT INTO CLIENTE (nome, rg, cpf, sexo, telefone,"
                    + " email, endereco, bairro, cidade, uf, cep, tg_status) VALUES "
                    + "(?,?,?,?,?,?,?,?,?,?,?,0)";

            PreparedStatement ps = connection.prepareStatement(SQL);

            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getRg());
            ps.setString(3, cliente.getCpf());
            ps.setString(4, cliente.getSexo());
            ps.setString(5, cliente.getTelefone());
            ps.setString(6, cliente.getEmail());
            ps.setString(7, cliente.getEndereco());
            ps.setString(8, cliente.getBairro());
            ps.setString(9, cliente.getCidade());
            ps.setString(10, cliente.getUf());
            ps.setString(11, cliente.getCep());

            ps.execute();
            ps.close();
            connection.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    //Metodo que busca todos os dados do cliente e adiciona em uma lista
    public ArrayList<Pessoa> listarTudo() {
        String SQL = "SELECT * FROM CLIENTE WHERE TG_STATUS=0";
        ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
        try {

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                Pessoa cliente = new Pessoa();
                cliente.setId(rs.getInt("ID"));
                cliente.setNome(rs.getString("NOME"));
                cliente.setCpf(rs.getString("CPF"));
                cliente.setTelefone(rs.getString("TELEFONE"));
                cliente.setEmail(rs.getString("EMAIL"));
                lista.add(cliente);

            }
            st.close();
            connection.close();
            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    // Metodo que procura pro cliente atraves do ID no banco e coloca em uma lista
    public ArrayList<Pessoa> listarID(int id) {
        String SQL = "SELECT * FROM CLIENTE WHERE ID = " + id + " AND TG_STATUS=0";
        ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                Pessoa cliente = new Pessoa();
                cliente.setId(rs.getInt("ID"));
                cliente.setNome(rs.getString("NOME"));
                cliente.setRg(rs.getString("RG"));
                cliente.setCpf(rs.getString("CPF"));
                cliente.setSexo(rs.getString("SEXO"));
                cliente.setTelefone(rs.getString("TELEFONE"));
                cliente.setEmail(rs.getString("EMAIL"));
                cliente.setEndereco(rs.getString("ENDERECO"));
                cliente.setBairro(rs.getString("BAIRRO"));
                cliente.setCidade(rs.getString("CIDADE"));
                cliente.setUf(rs.getString("UF"));
                cliente.setCep(rs.getString("CEP"));
                lista.add(cliente);

            }

            st.close();
            connection.close();
            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;

    }

    // Metodo para editar cliente
    public void Editar(Pessoa cliente) {

        try {

            String SQL = "UPDATE CLIENTE SET NOME=?, RG=?, CPF=?, SEXO=?, "
                    + "TELEFONE=?, EMAIL=?, ENDERECO=?, BAIRRO=?, CIDADE=?, UF=?, "
                    + "CEP=? WHERE ID=?";

            PreparedStatement ps = connection.prepareStatement(SQL);

            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getRg());
            ps.setString(3, cliente.getCpf());
            ps.setString(4, cliente.getSexo());
            ps.setString(5, cliente.getTelefone());
            ps.setString(6, cliente.getEmail());
            ps.setString(7, cliente.getEndereco());
            ps.setString(8, cliente.getBairro());
            ps.setString(9, cliente.getCidade());
            ps.setString(10, cliente.getUf());
            ps.setString(11, cliente.getCep());
            ps.setInt(12, cliente.getId());

            ps.execute();
            ps.close();
            connection.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    // Metodo que seta 0 para TG_STATUS inativando logicamente o elemento
    public void inativar(Pessoa cliente)
            throws SQLException, Exception {
        try {
            String sql = "UPDATE CLIENTE SET TG_STATUS =1 WHERE ID = ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, cliente.getId());

            pst.execute();
            pst.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
