package conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConection {
	//private static String url= "jdbc:mysql://localhost:3306/bancoteste";
	static String url = "jdbc:mysql://localhost:3306/bancoteste?useTimezone=true&serverTimezone=UTC";
	private static String user = "root";
	private static String password= "147893";
	private static Connection connection = null;
	
	static {
		conectar();
	}
	
	public SingleConection() {
		conectar();
	}
	
	private static void conectar() {
		try {
			if(connection==null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
				System.out.println("Conectou com Sucesso");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
	

}
