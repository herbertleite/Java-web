package dao;

import java.util.Scanner;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ngoncalves
 */
public class FabricaConexao {
	
	private static String banco = "jdbc:postgresql://localhost:5432/curso-jsp?autoReconnect=true";
	private static String password = getPassword();
	private static String user = "postgres";
	private static Connection connection = null;

	static {
		conectar();
	}
	
	private static String getPassword() {
		return "admin";
	}


	private static void conectar() {
		try {
			if (connection == null) {	
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(banco, user, password);
				connection.setAutoCommit(false);
			}
		} catch (Exception e) {		
		}
	}

    
    public static Connection getConexao() throws ClassNotFoundException, SQLException {
    	return connection;
    }
}
