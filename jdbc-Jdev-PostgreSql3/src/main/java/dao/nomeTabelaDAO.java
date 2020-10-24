package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexaojdbc.SingleConection;
import model.nomeTabela;

public class nomeTabelaDAO {
	
	private Connection connection;
	
	public nomeTabelaDAO() {
		connection = SingleConection.getConnection();
	}
	
	public void salvar(nomeTabela nomeTabela) {
		try {
			String sql = "insert into nomeTabela(id, nome, email) values (?,?,?)";
			PreparedStatement insert;
			insert = connection.prepareStatement(sql);
			insert.setLong(1, nomeTabela.getId());//interrogacao 1 conteudo
			insert.setString(2, nomeTabela.getNome());//interrogacao 2 conteudo
			insert.setString(3, nomeTabela.getEmail());//interrogacao 3 conteudo
			insert.execute();//executa
			connection.commit();//salva no banco
			
		} catch (SQLException e) {
			try {
				connection.rollback();//se der um erro desfaz as alteracoes feita no banco
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		
	}
}

