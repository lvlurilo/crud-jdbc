package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conexao.SingleConnect;
import model.Usuario;

public class UsuarioDAO {
	
	private Connection connection; //estabelece a coneao com banco de dados
	
	public UsuarioDAO(){
		connection = SingleConnect.getConnection(); // injeta a classe de conexao criada para esta classe noprorpio construtor
	}
	
	public void insert(Usuario usuario) {
		
		try {
			
			String sql = "INSERT INTO usuario(name, email, idade) VALUES (?, ?, ?)"; // Instruçao SQL
			PreparedStatement statement = connection.prepareStatement(sql); // prepara a instrucao para ser instanciada
			
			statement.setString(1, usuario.getName());
			statement.setString(2, usuario.getEmail());
			statement.setInt(3, usuario.getIdade());
			
			statement.execute();  // executa o sql
			connection.commit(); //salva no bd
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Usuario> readAll() throws Exception {
		
		List<Usuario> usuarios = new ArrayList<>();  //instancia a lista para guardar o retorno
		
		String sql = "SELECT * FROM usuario";  //query que realiza a consulta no bd
		
		PreparedStatement statement = connection.prepareStatement(sql);  //prepara o sql para ser executado
		ResultSet result = statement.executeQuery();  //executa o que foi preparado no bd
		
		while (result.next()) {  //enquanto a consulta tiver reultado monta o objeto
			Usuario usuario = new Usuario();
			usuario.setId(result.getLong("id"));
			usuario.setName(result.getString("name"));
			usuario.setEmail(result.getString("email"));
			usuario.setIdade(result.getInt("idade"));
			
			usuarios.add(usuario);	
		}
					
		return usuarios;
	}
	
public Usuario read(long id) throws Exception { // le apenas 1 linha do bd, de acordo com algum parametro
		
		Usuario usuario = new Usuario();  //instancia o usuario
		
		String sql = "SELECT * FROM usuario WHERE id =" + id;  //query que realiza a consulta no bd
		
		PreparedStatement statement = connection.prepareStatement(sql);  //prepara o sql para ser executado
		ResultSet result = statement.executeQuery();  //executa o que foi preparado no bd
		
		while (result.next()) {  //enquanto a consulta tiver reultado monta o objeto		
			usuario.setId(result.getLong("id"));
			usuario.setName(result.getString("name"));
			usuario.setEmail(result.getString("email"));
			usuario.setIdade(result.getInt("idade"));
		}
					
		return usuario;
	}

public void update(Usuario usuario) {
	
	try {
		
		String sql = "UPDATE usuario SET name = ? WHERE id = " + usuario.getId();
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setString(1, usuario.getName());
		
		statement.execute();
		connection.commit();  //salva no bd
		
	} catch (Exception e) {
		
		try {
			connection.rollback(); // cancela a query caso tenha algum erro			
		} catch (Exception e2) {
			e.printStackTrace();
		}
		e.printStackTrace();

	}
	
	
}

	public void delete(Long id) {
		
		try {
			
			String sql = "DELETE FROM usuario WHERE id =" + id;
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.execute();
			connection.commit();
			
		} catch (Exception e) {
			
				try {
					connection.rollback();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			
			e.printStackTrace();
		}
	}
		
		
}

