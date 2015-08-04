package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	public static Connection getConnection() {

		Connection c=null;
		try {
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/fabricawebdb323232", "postgres","postgres");
		} catch (SQLException e) {
			//Wrapper de Exception
			throw new RuntimeException("não conectou!", e);
		}
		return c;
	}
}
