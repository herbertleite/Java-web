package br.senac.pi3.brawan.DAO;

import br.senac.pi3.brawan.model.Empresa;
import br.senac.pi3.brawan.utils.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class EmpresaDAO {
    
    //Chama a conexao com o banco de dados
    Connection connection = ConnectionUtils.getConnection();

    
    // Metodo que insere os dados no banco
    public void inserir(Empresa empresa) {

        try {

            String SQL = "INSERT INTO EMPRESA (EMPRESA, DIRETOR, CNPJ, ENDERECO, BAIRRO,"
                    + " CIDADE, UF, CEP, TELEFONE, EMAIL, TG_STATUS) VALUES "
                    + "(?,?,?,?,?,?,?,?,?,?,0)";

           
            PreparedStatement ps = connection.prepareStatement(SQL);

            ps.setString(1, empresa.getEmpresa());
            ps.setString(2, empresa.getDiretor());
            ps.setString(3, empresa.getCnpj());
            ps.setString(4, empresa.getEndereco());
            ps.setString(5, empresa.getBairro());
            ps.setString(6, empresa.getCidade());
            ps.setString(7, empresa.getUf());
            ps.setString(8, empresa.getCep());
            ps.setString(9, empresa.getTelefone());
            ps.setString(10,empresa.getEmail());

            ps.execute();
            ps.close();
            connection.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    //Metodo para listar todos os dados
    public ArrayList<Empresa> listarTudo() {
        String SQL = "SELECT * FROM EMPRESA WHERE TG_STATUS=0";
        ArrayList<Empresa> lista = new ArrayList<Empresa>();
        try {

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                Empresa empresa = new Empresa();
                empresa.setId(rs.getInt("ID"));
                empresa.setEmpresa(rs.getString("EMPRESA"));
                empresa.setDiretor(rs.getString("DIRETOR"));
                empresa.setCnpj(rs.getString("CNPJ"));
                empresa.setEndereco(rs.getString("ENDERECO"));
                empresa.setBairro(rs.getString("BAIRRO"));
                empresa.setCidade(rs.getString("CIDADE"));
                empresa.setUf(rs.getString("UF"));
                empresa.setCep(rs.getString("CEP"));
                empresa.setTelefone(rs.getString("TELEFONE"));
                empresa.setEmail(rs.getString("EMAIL"));
                
                lista.add(empresa);

            }
            st.close();
            connection.close();
            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    // Metodo para listar por ID 
    public ArrayList<Empresa> listarID(int id) {
        String SQL = "SELECT * FROM EMPRESA WHERE ID = " + id + " AND TG_STATUS=0";
        ArrayList<Empresa> lista = new ArrayList<Empresa>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                Empresa empresa = new Empresa();
                empresa.setId(rs.getInt("ID"));
                empresa.setEmpresa(rs.getString("EMPRESA"));
                empresa.setDiretor(rs.getString("DIRETOR"));
                empresa.setCnpj(rs.getString("CNPJ"));
                empresa.setEndereco(rs.getString("ENDERECO"));
                empresa.setBairro(rs.getString("BAIRRO"));
                empresa.setCidade(rs.getString("CIDADE"));
                empresa.setUf(rs.getString("UF"));
                empresa.setCep(rs.getString("CEP"));
                empresa.setTelefone(rs.getString("TELEFONE"));
                empresa.setEmail(rs.getString("EMAIL"));
                
                lista.add(empresa);

            }

            st.close();
            connection.close();
            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;

    }

    //Metodo para Editar o elemento 
    public void Editar(Empresa empresa) {

        try {

            String SQL = "UPDATE EMPRESA SET EMPRESA=?, DIRETOR=?, CNPJ=?, ENDERECO=?, BAIRRO=?,"
                    + " CIDADE=?, UF=?, CEP=?, TELEFONE=?, EMAIL=? WHERE ID=?";

            PreparedStatement ps = connection.prepareStatement(SQL);

            ps.setString(1, empresa.getEmpresa());
            ps.setString(2, empresa.getDiretor());
            ps.setString(3, empresa.getCnpj());
            ps.setString(4, empresa.getEndereco());
            ps.setString(5, empresa.getBairro());
            ps.setString(6, empresa.getCidade());
            ps.setString(7, empresa.getUf());
            ps.setString(8, empresa.getCep());
            ps.setString(9, empresa.getTelefone());
            ps.setString(10,empresa.getEmail());
            ps.setInt(11, empresa.getId());

            ps.execute();
            ps.close();
            connection.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    //Metodo que seta 0 para TG_STATUS, inativando logicamente
    public void inativar(Empresa empresa)
            throws SQLException, Exception {
        try {
            String sql = "UPDATE EMPRESA SET TG_STATUS =1 WHERE ID = ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, empresa.getId());

            pst.execute();
            pst.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}


