package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexaojdbc.SingleConection;
import model.nomeTabela;

public class nomeTabelaDAO {

	private Connection connection;

	public nomeTabelaDAO() {
		connection = SingleConection.getConnection();
	}

	public void salvar(nomeTabela nomeTabela) {
		try {
			String sql = "insert into nomeTabela(nome, email) values (?,?)";
			PreparedStatement insert;
			insert = connection.prepareStatement(sql);
			insert.setString(1, nomeTabela.getNome());// interrogacao 1 conteudo
			insert.setString(2, nomeTabela.getEmail());// interrogacao 1 conteudo
			insert.execute();// executa
			connection.commit();// salva no banco

		} catch (SQLException e) {
			try {
				connection.rollback();// se der um erro desfaz as alteracoes feita no banco
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

	public ArrayList<nomeTabela> listar() throws Exception {
		ArrayList<nomeTabela> list = new ArrayList<nomeTabela>();
		String sql = "select * from  nometabela";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();

		while (resultado.next()) {
			nomeTabela nomeTabela = new nomeTabela();
			nomeTabela.setId(resultado.getLong("id"));
			nomeTabela.setNome(resultado.getString("nome"));
			nomeTabela.setEmail(resultado.getString("email"));
			list.add(nomeTabela);
		}
		return list;
	}
	
	
	public nomeTabela buscar(Long id) throws Exception {
		nomeTabela retorno = new nomeTabela();
		String sql = "select * from  nometabela where id = "+ id;
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();

		while (resultado.next()) {//retorna apenas 1 ou nehum
			nomeTabela nomeTabela = new nomeTabela();
			retorno.setId(resultado.getLong("id"));
			retorno.setNome(resultado.getString("nome"));
			retorno.setEmail(resultado.getString("email"));
		}
		return retorno;
	}
	
	
	public void atualizar(nomeTabela nomeTabela) {
		try {
			String sql = "update nomeTabela set nome = ? where id = "+ nomeTabela.getId();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, nomeTabela.getNome());
			statement.execute();
			connection.commit();
			
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}
	
	
	public void deletar(Long id) {
		try {
			String sql = "delete from nometabela where id =  "+ id;
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.execute();
			connection.commit();
			
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}
}
