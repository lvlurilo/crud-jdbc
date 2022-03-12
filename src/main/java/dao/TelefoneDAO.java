package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.SingleConnect;
import model.Telefone;
import model.UsuarioTelefone;

public class TelefoneDAO {

	private Connection connection; // estabelece a conexao com banco de dados

	public TelefoneDAO() {
		connection = SingleConnect.getConnection(); // injeta a classe de conexao criada para esta classe noprorpio
													// construtor
	}

	public void create(Telefone telefone) {

		try {

			String sql = "INSERT INTO telefone(numero, tipo, usuario_id) VALUES (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, telefone.getTelefone());
			statement.setString(2, telefone.getTipo());
			statement.setLong(3, telefone.getUsuario_id());
			
			statement.execute();
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}

	public List<Telefone> readAll() throws SQLException {

		String sql = "SELECT * FROM telefone";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet result = statement.executeQuery();

		List<Telefone> telefones = new ArrayList<Telefone>();
		while (result.next()) {
			Telefone telefone = new Telefone();
			telefone.setId(result.getString("id"));
			telefone.setTelefone(result.getString("numero"));
			telefone.setTipo(result.getString("tipo"));
			telefone.setUsuario_id(result.getLong("usuario_id"));

			telefones.add(telefone);
		}

		return telefones;

	}
	

	public Telefone read(Long id) throws SQLException {

		String sql = "SELECT * FROM telefone WHERE id = " + id;
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet result = statement.executeQuery();

		Telefone telefone = new Telefone();

		telefone.setId(result.getString("id"));
		telefone.setTelefone(result.getString("numero"));
		telefone.setTipo(result.getString("tipo"));
		telefone.setUsuario_id(result.getLong("usuario_id"));

		return telefone;

	}

	public void updateNumero(Telefone telefone) {

		try {
			String sql = "UPDATE telefone SET numero = ? WHERE id =" + telefone.getId();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, telefone.getTelefone());
			
			statement.execute();
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void delete(Long id) {

		try {
			String sql = "DELETE FROM telefone WHERE id = " + id;
			PreparedStatement delete = connection.prepareStatement(sql);
			delete.execute();
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
			try {

				connection.rollback();

			} catch (Exception e2) {
				e2.printStackTrace();

			}
		}

	}
	

	public List<UsuarioTelefone> readUsuarioTelefone(Long id) throws SQLException {

		List<UsuarioTelefone> usuarioTelefones = new ArrayList<UsuarioTelefone>();

		String sql = " SELECT name, email, numero FROM telefone as tel ";
		sql += " INNER JOIN usuario as usuar ";
		sql += " on tel.usuario_id = usuar.id ";
		sql += " Where usuar.id = " + id;
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet result = statement.executeQuery();

		while (result.next()) {

			UsuarioTelefone usuarioTelefone = new UsuarioTelefone();
			usuarioTelefone.setName(result.getString("name"));
			usuarioTelefone.setEmail(result.getString("email"));
			usuarioTelefone.setTelefone(result.getString("numero"));

			usuarioTelefones.add(usuarioTelefone);
		}

		return usuarioTelefones;

	}

	public List<UsuarioTelefone> readAllUsuarioTelefone() throws SQLException {

		List<UsuarioTelefone> usuarioTelefones = new ArrayList<UsuarioTelefone>();
		
		String sql = " SELECT name, email, numero FROM telefone as tel ";
		sql += " INNER JOIN usuario as usuar ";
		sql += " on tel.usuario_id = usuar.id ";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet result = statement.executeQuery();

		while (result.next()) {

			UsuarioTelefone usuarioTelefone = new UsuarioTelefone();
			usuarioTelefone.setName(result.getString("name"));
			usuarioTelefone.setEmail(result.getString("email"));
			usuarioTelefone.setTelefone(result.getString("numero"));

			usuarioTelefones.add(usuarioTelefone);
		}

		return usuarioTelefones;

	}

	public void deleteTelefoneUsuario(Long id) {

		try {
			String sqlTelefone = "DELETE FROM telefone WHERE usuario_id = " + id;
			PreparedStatement statement = connection.prepareStatement(sqlTelefone);
			statement.execute();
			connection.commit();

			String sqlUsuario = "DELETE FROM usuario WHERE id =" + id;
			PreparedStatement statementUser = connection.prepareStatement(sqlUsuario);
			statementUser.execute();
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
			try {

				connection.rollback();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
