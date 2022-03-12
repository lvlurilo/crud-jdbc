package model;

public class Telefone {
	
	private String id;
	private String telefone;
	private String tipo;
	private Long usuario_id;
	
	public Telefone(){	
	}
	
	public Telefone(String telefone, String tipo, Long usuario_id){
		setTelefone(telefone);
		setTipo(tipo);
		setUsuario_id(usuario_id);	
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Long usuario_id) {
		this.usuario_id = usuario_id;
	}

	@Override
	public String toString() {
		return "Telefone [id=" + id + ", telefone=" + telefone + ", tipo=" + tipo + ", usuario_id=" + usuario_id + "]";
	}
	
}
