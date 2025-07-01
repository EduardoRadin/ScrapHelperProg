package model;

public class CEP {
	private int cep_cod;
	private int cod_mun;
	
	public CEP(int cep_cod, int cod_mun) {
		this.cep_cod = cep_cod;
		this.cod_mun = cod_mun;
	}

	public CEP() {
	}

	public String toString() {
		return "CEP: " + cep_cod 
				+ "\n Código do Município" + cod_mun;
	}

	public int getCep_cod() {
		return cep_cod;
	}

	public void setCep_cod(int cep_cod) {
		this.cep_cod = cep_cod;
	}

	public int getCod_mun() {
		return cod_mun;
	}

	public void setCod_mun(int cod_mun) {
		this.cod_mun = cod_mun;
	}
}
