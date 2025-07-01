package model;

public class Estado {

	private int estado_cod;
	private String estado_sigla;
	private String estado_nome;
	
	public Estado() {
	}

	public Estado(int estado_cod, String estado_sigla, String estado_nome) {
		this.estado_cod = estado_cod;
		this.estado_sigla = estado_sigla;
		this.estado_nome = estado_nome;
	}

	
	@Override
	public String toString() {
		return "Estado estado_cod=" + estado_cod 
				+ ", estado_sigla=" + estado_sigla 
				+ ", estado_nome=" + estado_nome;
	}

	public int getEstado_cod() {
		return estado_cod;
	}

	public void setEstado_cod(int estado_cod) {
		this.estado_cod = estado_cod;
	}

	public String getEstado_sigla() {
		return estado_sigla;
	}

	public void setEstado_sigla(String estado_sigla) {
		this.estado_sigla = estado_sigla;
	}

	public String getEstado_nome() {
		return estado_nome;
	}

	public void setEstado_nome(String estado_nome) {
		this.estado_nome = estado_nome;
	}
	
	
}
