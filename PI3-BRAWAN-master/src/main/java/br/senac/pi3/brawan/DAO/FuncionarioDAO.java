package br.senac.pi3.brawan.DAO;

import br.senac.pi3.brawan.model.Funcionario;
import br.senac.pi3.brawan.utils.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FuncionarioDAO {

    
    //Metodo que insere os dados no banco de dado
    public void inserir(Funcionario func) throws SQLException, Exception {
        String sqlComando = "";

        Connection connection = ConnectionUtils.getConnection();
        Statement buscaEmpresa = connection.createStatement();

        // BUSCA O ID DA EMPRESA NA QUAL O FUNCIONARIO FOI CADASTRADO
        ResultSet resultado = buscaEmpresa.executeQuery("SELECT EMP.ID FROM EMPRESA AS EMP "
                + "WHERE EMPRESA LIKE '" + func.getEmpresa().trim() + "%'");

        try {
            if (resultado != null && resultado.next()) {
                func.setIdEmpresa(resultado.getInt("EMP.ID"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        sqlComando = "INSERT INTO FUNCIONARIO "
                + "(LOGIN, SENHA, NOME, RG, CPF, TELEFONE, ENDERECO,"
                + "BAIRRO, CIDADE, UF, CEP, EMAIL, SEXO, CARGO, EMPRESA, FK_EMPRESA,TG_STATUS)"
                + "VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0);";

        PreparedStatement pst = connection.prepareStatement(sqlComando);

        try {
            if (connection != null) {
                pst.setString(1, func.getLogin());
                pst.setString(2, func.getSenha());
                pst.setString(3, func.getNome());
                pst.setString(4, func.getRg());
                pst.setString(5, func.getCpf());
                pst.setString(6, func.getTelefone());
                pst.setString(7, func.getEndereco());
                pst.setString(8, func.getBairro());
                pst.setString(9, func.getCidade());
                pst.setString(10, func.getUf());
                pst.setString(11, func.getCep());
                pst.setString(12, func.getEmail());
                pst.setString(13, func.getSexo());
                pst.setString(14, func.getCargo());
                pst.setString(15, func.getEmpresa());
                pst.setInt(16, func.getIdEmpresa());

                pst.execute();
            }
        } finally {
            if (pst != null && !pst.isClosed()) {
                pst.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }

    }

    // Metodo que edita os daods no banco de dados
    public void editar(Funcionario func) throws SQLException, Exception {

        String sqlComando = "";

        Connection connection = ConnectionUtils.getConnection();
        Statement buscaEmpresa = connection.createStatement();

        // BUSCA O ID DA EMPRESA NA QUAL O FUNCIONARIO FOI CADASTRADO
        ResultSet resultado
                = buscaEmpresa.executeQuery("SELECT * FROM EMPRESA WHERE EMPRESA LIKE '" + func.getEmpresa().trim() + "'");

        try {
            if (resultado != null && resultado.next()) {
                func.setIdEmpresa(resultado.getInt("ID"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        sqlComando = "UPDATE FUNCIONARIO SET LOGIN=?, SENHA=?, NOME=?, RG=?, CPF=?, TELEFONE=?, ENDERECO=?,"
                + "BAIRRO=?, CIDADE=?, UF=?, CEP=?, EMAIL=?, SEXO=?, CARGO=?, EMPRESA=?, FK_EMPRESA=? WHERE ID=?";

        PreparedStatement pst = connection.prepareStatement(sqlComando);

        try {

            pst.setString(1, func.getLogin());
            pst.setString(2, func.getSenha());
            pst.setString(3, func.getNome());
            pst.setString(4, func.getRg());
            pst.setString(5, func.getCpf());
            pst.setString(6, func.getTelefone());
            pst.setString(7, func.getEndereco());
            pst.setString(8, func.getBairro());
            pst.setString(9, func.getCidade());
            pst.setString(10, func.getUf());
            pst.setString(11, func.getCep());
            pst.setString(12, func.getEmail());
            pst.setString(13, func.getSexo());
            pst.setString(14, func.getCargo());
            pst.setString(15, func.getEmpresa());
            pst.setInt(16, func.getIdEmpresa());

            pst.setInt(17, func.getId());
            pst.execute();
        } finally {
            if (pst != null && !pst.isClosed()) {
                pst.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    //Metodo que seta 0 para TG_STATUS, inativando logicamento o elemento
    public void inativar(Funcionario funcionario)
            throws SQLException, Exception {
        try {
            String sql = "UPDATE FUNCIONARIO SET TG_STATUS =1 WHERE ID = ?";
            Connection connection = ConnectionUtils.getConnection();
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, funcionario.getId());

            pst.execute();
            pst.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //Metodo que lista todos os dados do banco de dados
    public ArrayList<Funcionario> listarTudo()
            throws SQLException, ClassNotFoundException {


        ArrayList<Funcionario> listarFunc = new ArrayList<Funcionario>();

        Connection connection = ConnectionUtils.getConnection();
        Statement pst = connection.createStatement();

        ResultSet resultado = pst.executeQuery("SELECT * FROM FUNCIONARIO WHERE TG_STATUS=0");

        while (resultado.next()) {

            Funcionario func = new Funcionario();
            func.setId(resultado.getInt("ID"));
            func.setLogin(resultado.getString("LOGIN"));
            func.setSenha(resultado.getString("SENHA"));
            func.setNome(resultado.getString("NOME"));
            func.setRg(resultado.getString("RG"));
            func.setCpf(resultado.getString("CPF"));
            func.setTelefone(resultado.getString("TELEFONE"));
            func.setEndereco(resultado.getString("ENDERECO"));
            func.setBairro(resultado.getString("BAIRRO"));
            func.setCidade(resultado.getString("CIDADE"));
            func.setUf(resultado.getString("UF"));
            func.setCep(resultado.getString("CEP"));
            func.setEmail(resultado.getString("EMAIL"));
            func.setSexo(resultado.getString("SEXO"));
            func.setCargo(resultado.getString("CARGO"));
            func.setEmpresa(resultado.getString("EMPRESA"));
            func.setIdEmpresa(resultado.getInt("FK_EMPRESA"));
            

            listarFunc.add(func);
        }
        if (pst != null && !pst.isClosed()) {
            pst.close();
        }
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
        return listarFunc;
    }
    
    //Metodo que lista elemento pelo ID
    public ArrayList<Funcionario> listarID(int id)
            throws SQLException, ClassNotFoundException {


        ArrayList<Funcionario> listarFunc = new ArrayList<Funcionario>();

        Connection connection = ConnectionUtils.getConnection();
        Statement pst = connection.createStatement();

        ResultSet resultado = pst.executeQuery("SELECT * FROM FUNCIONARIO WHERE TG_STATUS=0 AND ID ="+id);

        while (resultado.next()) {

            Funcionario func = new Funcionario();
            func.setId(resultado.getInt("ID"));
            func.setLogin(resultado.getString("LOGIN"));
            func.setSenha(resultado.getString("SENHA"));
            func.setNome(resultado.getString("NOME"));
            func.setRg(resultado.getString("RG"));
            func.setCpf(resultado.getString("CPF"));
            func.setTelefone(resultado.getString("TELEFONE"));
            func.setEndereco(resultado.getString("ENDERECO"));
            func.setBairro(resultado.getString("BAIRRO"));
            func.setCidade(resultado.getString("CIDADE"));
            func.setUf(resultado.getString("UF"));
            func.setCep(resultado.getString("CEP"));
            func.setEmail(resultado.getString("EMAIL"));
            func.setSexo(resultado.getString("SEXO"));
            func.setCargo(resultado.getString("CARGO"));
            func.setEmpresa(resultado.getString("EMPRESA"));
            func.setIdEmpresa(resultado.getInt("FK_EMPRESA"));
            

            listarFunc.add(func);
        }
        if (pst != null && !pst.isClosed()) {
            pst.close();
        }
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
        return listarFunc;
    }

}
