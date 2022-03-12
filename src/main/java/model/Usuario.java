package model;

public class Usuario {
	
	private Long id;
	private String name;
	private String email;
	private int idade;
	
	public Usuario(){	
	}
	
	Usuario(Long id, String name, String email, int idade){
		setId(id);
		setName(name);
		setEmail(email);
		setIdade(idade);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", name=" + name + ", email=" + email + ", idade=" + idade + "]";
	}	

}
