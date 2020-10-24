package dao;

import java.sql.Connection;

import conexaojdbc.SingleConection;

public class nomeTabelaDAO {
	private Connection connection;
	
	public nomeTabelaDAO() {
		connection = SingleConection.getConnection();
	}
}
