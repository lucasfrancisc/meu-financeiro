package model.dao.database.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.entity.Titulo;

public class TituloDAO {

	private ConnectionParametros parametros;
	
	public TituloDAO(ConnectionParametros parametros) {
		this.parametros = parametros;
	}
	
	public void add(Titulo titulo) {
		ConnectionUtil util = new ConnectionUtil();
		Connection conexao = util.criarConexao(parametros);
		
		String sql = " INSERT INTO titulo (descricao, tipo, emissao, valor) "+
					 " VALUES (?, ?, ?, ?)";	
		try {
			PreparedStatement ponte = conexao.prepareStatement(sql);
			ponte.setString(1, titulo.getDescricao());
			ponte.setString(2, titulo.getTipo()); 
			ponte.setDate(3, new Date(titulo.getEmissao().getTime()));
			ponte.setBigDecimal(4, titulo.getValor());
			ponte.execute();
			
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Titulo consultar(Long id) {
		Titulo titulo = new Titulo();
		
		ConnectionUtil util = new ConnectionUtil();
		Connection conexao = util.criarConexao(parametros);
		
		String sql = " SELECT * 	 "+
					 "   FROM titulo "+
					 "  WHERE id = ? ";
		
		try {
			PreparedStatement ponte = conexao.prepareStatement(sql);
			ponte.setLong(1, id);			
			ResultSet rs = ponte.executeQuery();
			if (rs.next()) {
				titulo.setId(id);
				titulo.setDescricao(rs.getString("descricao"));
				titulo.setTipo(rs.getString("tipo"));
				titulo.setEmissao(rs.getDate("emissao"));
				titulo.setValor(rs.getBigDecimal("valor"));
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
		
		return titulo;
	}	
	
	public void update(Titulo t) {
		ConnectionUtil util = new ConnectionUtil();
		Connection conexao = util.criarConexao(parametros);
		
		String sql = " UPDATE titulo "+
					 " SET descricao = ?, "+
					 "     tipo = ?,      "+
					 "     emissao = ?,   "+
					 "	   valor = ?      "+
					 " WHERE id = ?       ";
		try {
			PreparedStatement ponte = conexao.prepareStatement(sql);
			ponte.setString(1, t.getDescricao());
			ponte.setString(2, t.getTipo());
			ponte.setDate(3,  new Date(t.getEmissao().getTime()));
			ponte.setBigDecimal(4,  t.getValor());
			ponte.setLong(5,  t.getId());
			ponte.execute();
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void delete(Long id) {
		ConnectionUtil util = new ConnectionUtil();
		Connection conexao = util.criarConexao(parametros);
		
		StringBuilder str = new StringBuilder();
		str.append(" DELETE FROM titulo ");
		str.append(" WHERE id = ?");
		
		try {
			PreparedStatement ponte = conexao.prepareStatement(str.toString());
			ponte.setLong(1, id);
			ponte.execute();
			
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}