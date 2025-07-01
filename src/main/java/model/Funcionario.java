package model;

import java.time.LocalDate;

public class Funcionario {
	private int fun_cod;
	private int cod_cargo;
	private String fun_nome;
	private String fun_cpf;
	private String fun_rg;
	private LocalDate fun_data_nas;
	private char fun_gen;

	public Funcionario(int fun_cod, int cod_cargo, String fun_nome, String fun_cpf, String fun_rg,
			LocalDate fun_data_nas, char fun_gen) {
		this.fun_cod = fun_cod;
		this.cod_cargo = cod_cargo;
		this.fun_nome = fun_nome;
		this.fun_cpf = fun_cpf;
		this.fun_rg = fun_rg;
		this.fun_data_nas = fun_data_nas;
		this.fun_gen = fun_gen;
	}

	public Funcionario() {
	}

	@Override
	public String toString() {
		return "Funcionario fun_cod=" + fun_cod + ", cod_cargo=" + cod_cargo + ", fun_nome=" + fun_nome + ", fun_cpf="
				+ fun_cpf + ", fun_rg=" + fun_rg + ", fun_data_nas=" + fun_data_nas + ", fun_gen=" + fun_gen;
	}

	public int getFun_cod() {
		return fun_cod;
	}

	public void setFun_cod(int fun_cod) {
		this.fun_cod = fun_cod;
	}

	public int getCod_cargo() {
		return cod_cargo;
	}

	public void setCod_cargo(int cod_cargo) {
		this.cod_cargo = cod_cargo;
	}

	public String getFun_nome() {
		return fun_nome;
	}

	public void setFun_nome(String fun_nome) {
		this.fun_nome = fun_nome;
	}

	public String getFun_cpf() {
		return fun_cpf;
	}

	public void setFun_cpf(String fun_cpf) {
		this.fun_cpf = fun_cpf;
	}

	public String getFun_rg() {
		return fun_rg;
	}

	public void setFun_rg(String fun_rg) {
		this.fun_rg = fun_rg;
	}

	public LocalDate getFun_data_nas() {
		return fun_data_nas;
	}

	public void setFun_data_nas(LocalDate fun_data_nas) {
		this.fun_data_nas = fun_data_nas;
	}

	public char getFun_gen() {
		return fun_gen;
	}

	public void setFun_gen(char fun_gen) {
		this.fun_gen = fun_gen;
	}

}
