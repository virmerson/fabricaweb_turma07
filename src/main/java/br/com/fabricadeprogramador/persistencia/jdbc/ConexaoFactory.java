package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	public static Connection getConnection() {
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection c=null;
		try {
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/fabricawebdb", "postgres","postgres");
		} catch (SQLException e) {
			//Wrapper de Exception
			throw new RuntimeException("não conectou!", e);
		}
		return c;
	}
}
