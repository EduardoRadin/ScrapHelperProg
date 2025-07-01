package model;

public class Usuario {
	private int cod_funcionario;
	private int usu_permissao;
	private String usu_login;
	private String usu_senha;
	public Usuario(int cod_funcionario, int usu_permissao, String usu_login, String usu_senha) {
		super();
		this.cod_funcionario = cod_funcionario;
		this.usu_permissao = usu_permissao;
		this.usu_login = usu_login;
		this.usu_senha = usu_senha;
	}
	public Usuario() {
		
	}
	public int getCod_funcionario() {
		return cod_funcionario;
	}
	public void setCod_funcionario(int cod_funcionario) {
		this.cod_funcionario = cod_funcionario;
	}
	public int getUsu_permissao() {
		return usu_permissao;
	}
	public void setUsu_permissao(int usu_permissao) {
		this.usu_permissao = usu_permissao;
	}
	public String getUsu_login() {
		return usu_login;
	}
	public void setUsu_login(String usu_login) {
		this.usu_login = usu_login;
	}
	public String getUsu_senha() {
		return usu_senha;
	}
	public void setUsu_senha(String usu_senha) {
		this.usu_senha = usu_senha;
	}
	@Override
	public String toString() {
		return "Usuario cod_funcionario=" + cod_funcionario 
				+ ", usu_permissao=" + usu_permissao 
				+ ", usu_login="+ usu_login 
				+ ", usu_senha=" + usu_senha;
	}
	
	
	
}
