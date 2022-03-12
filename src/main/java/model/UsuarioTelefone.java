package model;

public class UsuarioTelefone {
	
	private String name;
	private String email;
	private String telefone;
	
	public UsuarioTelefone() {	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "UsuarioTelefone [name=" + name + ", email=" + email + ", telefone=" + telefone + "]";
	}	

}
