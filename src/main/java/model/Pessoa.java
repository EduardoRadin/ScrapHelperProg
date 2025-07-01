package model;

public class Pessoa {
	private int pes_cod;
	private String pes_nome;
	private String pes_tipo;
	private String pes_cpf_cnpj;
	private String pes_gen;
	private String pes_data_nas;
	
	public Pessoa(int pes_cod, String pes_nome, String pes_tipo, String pes_cpf_cnpj, String pes_gen,
			String pes_data_nas) {
		this.pes_cod = pes_cod;
		this.pes_nome = pes_nome;
		this.pes_tipo = pes_tipo;
		this.pes_cpf_cnpj = pes_cpf_cnpj;
		this.pes_gen = pes_gen;
		this.pes_data_nas = pes_data_nas;
	}
	public Pessoa() {
	}
	@Override
	public String toString() {
		return "Código da Pessoa: " + pes_cod 
				+ "\nNome: " + pes_nome 
				+ "\nTipo: " + pes_tipo 
				+ "\nCPF ou CNPJ: " + pes_cpf_cnpj 
				+ "\nGenero: " + pes_gen 
				+ "\nNascimento: " + pes_data_nas;
	}
	public int getPes_cod() {
		return pes_cod;
	}
	public void setPes_cod(int pes_cod) {
		this.pes_cod = pes_cod;
	}
	public String getPes_nome() {
		return pes_nome;
	}
	public void setPes_nome(String pes_nome) {
		this.pes_nome = pes_nome;
	}
	public String getPes_tipo() {
		return pes_tipo;
	}
	public void setPes_tipo(String pes_tipo) {
		this.pes_tipo = pes_tipo;
	}
	public String getPes_cpf_cnpj() {
		return pes_cpf_cnpj;
	}
	public void setPes_cpf_cnpj(String pes_cpf_cnpj) {
		this.pes_cpf_cnpj = pes_cpf_cnpj;
	}
	public String getPes_gen() {
		return pes_gen;
	}
	public void setPes_gen(String pes_gen) {
		this.pes_gen = pes_gen;
	}
	public String getPes_data_nas() {
		return pes_data_nas;
	}
	public void setPes_data_nas(String pes_data_nas) {
		this.pes_data_nas = pes_data_nas;
	}
		
}
