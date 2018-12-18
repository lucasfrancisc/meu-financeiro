package model.dao.database.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DatabaseUtil {

	private static DatabaseUtil instanciaUnica;
	private ConnectionParametros parametros;
	
	private DatabaseUtil(){
	}
	
	public static DatabaseUtil getInstanciaUnica() {
		if (instanciaUnica == null) {
			instanciaUnica = new DatabaseUtil();
			
			ResourceBundle file = ResourceBundle.getBundle("database");
			String driver = file.getString("driver");
			String caminho = file.getString("caminho");
			String usuario = file.getString("usuario");
			String senha = file.getString("senha");
			
			instanciaUnica.parametros = new ConnectionParametros();
			instanciaUnica.parametros.setDriver(driver);
			instanciaUnica.parametros.setCaminho(caminho);
			instanciaUnica.parametros.setUsuario(usuario);
			instanciaUnica.parametros.setSenha(senha);
		}
		
		return instanciaUnica;
	}

	public ConnectionParametros getParametros() {
		return parametros;
	}

	public void setParametros(ConnectionParametros parametros) {
		this.parametros = parametros;
	}
}
