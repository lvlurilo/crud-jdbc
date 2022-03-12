package maven_jdbc.maven_jdbc;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import conexao.SingleConnect;
import dao.TelefoneDAO;
import dao.UsuarioDAO;
import model.Telefone;
import model.Usuario;
import model.UsuarioTelefone;

public class AppTest {
	
    @Test
    public void CadastrarBD() {
        
    	SingleConnect.getConnection();
    	
    	UsuarioDAO usuarioDao = new UsuarioDAO();
    	Usuario usuario = new Usuario();
 
    	usuario.setName("usuario");
    	usuario.setEmail("usuario@email.com");
    	usuario.setIdade(22);
    	
    	usuarioDao.insert(usuario);	
    	
    }
    
    @Test
    public void buscarTodosBD() {
    	
    	UsuarioDAO usuarioDao = new UsuarioDAO();
    	
    	try {
    		
    		List<Usuario> usuarios = usuarioDao.readAll();
    		
    		for(Usuario user : usuarios) {
    			System.out.println(user);
    		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    
    @Test
    public void buscarBD() {
    	
    	UsuarioDAO usuarioDao = new UsuarioDAO();
    	
    	try {
			
    		Usuario usuario = usuarioDao.read(1L);		
    		System.out.println(usuario);
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	   	
    }
    
    @Test
    public void editarBD() {
    	
    	try {
    		
    		UsuarioDAO usuarioDao = new UsuarioDAO();
    		
    		Usuario usuario = usuarioDao.read(1L);
    		
			usuario.setName("Murilo Carvalho");
			
			usuarioDao.update(usuario);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    
    }
    
    @Test
    public void excluirBD() {
    	
    	try {
    		
    		UsuarioDAO usuarioDao = new UsuarioDAO();
    		
    		usuarioDao.delete(1L);
    		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
    }
    
    @Test
    public void cadastrarTelBD() {
    	
    	SingleConnect.getConnection();
    	
    	TelefoneDAO telefoneDAO = new TelefoneDAO();
    	Telefone telefone = new Telefone();
    	
    	telefone.setTelefone("4755555555");
    	telefone.setTipo("celular");
    	telefone.setUsuario_id(1L);
    	
    	telefoneDAO.create(telefone);  	
    	
    }
    
    @Test
    public void listarTodosTelefoneBD() {
    	
    	TelefoneDAO telefoneDAO = new TelefoneDAO();
    	
    	try {
    		
    		List <Telefone> telefones = telefoneDAO.readAll();
    		
    		for(Telefone tel : telefones) {
    			System.out.println(tel.toString());
    		}
    		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
    
    @Test 
    public void listarTelefoneBD() {
    	
    	TelefoneDAO telefoneDAO = new TelefoneDAO();
    	
    	try {
    		Telefone telefone = telefoneDAO.read(1L);
    		if(telefone.getId() != null) {
    			System.out.println(telefone);
    		}else {
    			System.out.println("ID nao existe");
    		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    @Test
    public void editarTelefoneBD()  {
    	
    	TelefoneDAO telefoneDAO = new TelefoneDAO();
    	
    	try {
    		Telefone telefone = telefoneDAO.read(1L);
    		
    		telefone.setTelefone("4799999999");
    		
    		telefoneDAO.updateNumero(telefone);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
    }
    
    @Test
    public void listarUsuarioTelefone() throws SQLException {
    	
    	TelefoneDAO telefoneDAO = new TelefoneDAO();
    	
    	
    	try {
    		
    		List<UsuarioTelefone> usuarioTelefones = telefoneDAO.readUsuarioTelefone(1L);
    		for(UsuarioTelefone userTel : usuarioTelefones) {
    			System.out.println(userTel.toString());
    		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @Test
    public void listarTodosUsuarioTelefone() throws SQLException {
    	
    	TelefoneDAO telefoneDAO = new TelefoneDAO();
    	
    	
    	try {
    		
    		List<UsuarioTelefone> usuarioTelefones = telefoneDAO.readAllUsuarioTelefone();
    		for(UsuarioTelefone userTel : usuarioTelefones) {
    			System.out.println(userTel.toString());
    		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @Test
    public void deleteTelefoneBD() {
    	
    	TelefoneDAO telefoneDAO = new TelefoneDAO();
    	
    	telefoneDAO.delete(1L);
    	
    }
    
    @Test
    public void deleteTelefoneUsuarioBD() {
    	
    	TelefoneDAO telefoneDAO = new TelefoneDAO();
    	
    	telefoneDAO.deleteTelefoneUsuario(1L);
    }	   
    
}
