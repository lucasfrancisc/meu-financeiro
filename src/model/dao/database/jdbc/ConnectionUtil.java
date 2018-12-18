package model.dao.database.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	public Connection criarConexao(ConnectionParametros params) {
		try {
			Class.forName(params.getDriver());
			Connection conexao = DriverManager.getConnection(params.getCaminho(), params.getUsuario(), params.getSenha());
			System.out.print("Conectei!");
			
			return conexao;
		} catch(SQLException e) {
			throw new RuntimeException(e); 
		} catch(ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
