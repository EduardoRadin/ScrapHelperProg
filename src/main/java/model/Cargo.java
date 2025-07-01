package model;

public class Cargo {
	private int cargo_cod;
	private String cargo_descricao;
	private float cargo_salario;
	public Cargo(int cargo_cod, String cargo_descricao, float cargo_salario) {
		this.cargo_cod = cargo_cod;
		this.cargo_descricao = cargo_descricao;
		this.cargo_salario = cargo_salario;
	}
	public Cargo() {
	}
	@Override
	public String toString() {
		return "Cargo cargo_cod=" + cargo_cod 
				+ ", cargo_descricao=" + cargo_descricao 
				+ ", cargo_salario=" + cargo_salario;
	}
	
	public int getCargo_cod() {
		return cargo_cod;
	}
	public void setCargo_cod(int cargo_cod) {
		this.cargo_cod = cargo_cod;
	}
	public String getcargo_descricao() {
		return cargo_descricao;
	}
	public void setcargo_descricao(String cargo_descricao) {
		this.cargo_descricao = cargo_descricao;
	}
	public float getCargo_salario() {
		return cargo_salario;
	}
	public void setCargo_salario(float cargo_salario) {
		this.cargo_salario = cargo_salario;
	}
	
}
