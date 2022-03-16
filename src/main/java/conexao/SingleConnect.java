package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnect {
	// conexoes no BD sao feitas 1x apenas, o que é aberto e fechado sao sessoes
	private static String url = "jdbc:postgresql://localhost:5432/cadastro"; //padrao para conexao local postgre 
	private static String password = "admin";  //senha do bd
	private static String user = "postgres"; // owner do bd
	private static Connection connection = null;  // classe de conexao 
	
	
	static {	
			Connect();
	}
	
	public SingleConnect() {
		Connect();
		
	}
	 
	public static void Connect() {
		try {
			
			if(connection == null) {
				Class.forName("org.postgresql.Driver"); // carrega o criver do BD utilizado no projeto
				connection = DriverManager.getConnection(url, user, password); // congfigura os dados de conexao
				connection.setAutoCommit(false); // nao é salvo automaticamente, mas sim decidido pelo programador
				System.out.println("Conectado com Sucesso!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() {
		return connection;
	}
	

}
