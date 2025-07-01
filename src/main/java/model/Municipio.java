package model;

public class Municipio {
	private int mun_cod;
	private int cod_estado;
	private String mun_nome;
	
	
	public Municipio(int mun_cod, int cod_estado, String mun_nome) {
		this.mun_cod = mun_cod;
		this.cod_estado = cod_estado;
		this.mun_nome = mun_nome;
	}

	public Municipio() {
	}

	public String toString() {
		return "Código de Municipio: " + mun_cod 
				+ "\nCódigo de Estado: " + cod_estado 
				+ "\nNome do Município=" + mun_nome;
	}
	
	public int getMun_cod() {
		return mun_cod;
	}
	public void setMun_cod(int mun_cod) {
		this.mun_cod = mun_cod;
	}
	public int getCod_estado() {
		return cod_estado;
	}
	public void setCod_estado(int cod_estado) {
		this.cod_estado = cod_estado;
	}
	public String getMun_nome() {
		return mun_nome;
	}
	public void setMun_nome(String mun_nome) {
		this.mun_nome = mun_nome;
	}
	
}
