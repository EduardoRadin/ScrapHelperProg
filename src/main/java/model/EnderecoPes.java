package model;

public class EnderecoPes {
	private int end_pes_id;
	private int cod_pessoa;
	private int cod_tipo_endereco;
	private int cod_cep;
	private String end_pes_bairro;
	private String end_pes_rua;
	private String end_pes_numero;
	private String end_pes_telefone;
	private String end_pes_celular;
	private String end_pes_email;
	
	public EnderecoPes(int end_pes_id, int cod_pessoa, int cod_tipo_endereco, int cod_cep, String end_pes_bairro,
			String end_pes_rua, String end_pes_numero, String end_pes_telefone, String end_pes_celular,
			String end_pes_email) {
		this.end_pes_id = end_pes_id;
		this.cod_pessoa = cod_pessoa;
		this.cod_tipo_endereco = cod_tipo_endereco;
		this.cod_cep = cod_cep;
		this.end_pes_bairro = end_pes_bairro;
		this.end_pes_rua = end_pes_rua;
		this.end_pes_numero = end_pes_numero;
		this.end_pes_telefone = end_pes_telefone;
		this.end_pes_celular = end_pes_celular;
		this.end_pes_email = end_pes_email;
	}

	public EnderecoPes() {
	}

	public String toString() {
		return "ID do endereço da pessoa: " + end_pes_id 
				+ "\nCódigo da Pessoa: " + cod_pessoa 
				+ "\nCódigo do Tipo da Pessoa: " + cod_tipo_endereco 
				+ "\nCEP: " + cod_cep 
				+ "\nBairro: " + end_pes_bairro 
				+ "\nRua: " + end_pes_rua 
				+ "\nNumero: " + end_pes_numero 
				+ "\nTelefone: " + end_pes_telefone
				+ "\nCelular: " + end_pes_celular 
				+ "\nE-mail: " + end_pes_email;
	}

	public int getEnd_pes_id() {
		return end_pes_id;
	}

	public void setEnd_pes_id(int end_pes_id) {
		this.end_pes_id = end_pes_id;
	}

	public int getCod_pessoa() {
		return cod_pessoa;
	}

	public void setCod_pessoa(int cod_pessoa) {
		this.cod_pessoa = cod_pessoa;
	}

	public int getCod_tipo_endereco() {
		return cod_tipo_endereco;
	}

	public void setCod_tipo_endereco(int cod_tipo_endereco) {
		this.cod_tipo_endereco = cod_tipo_endereco;
	}

	public int getCod_cep() {
		return cod_cep;
	}

	public void setCod_cep(int cod_cep) {
		this.cod_cep = cod_cep;
	}

	public String getEnd_pes_bairro() {
		return end_pes_bairro;
	}

	public void setEnd_pes_bairro(String end_pes_bairro) {
		this.end_pes_bairro = end_pes_bairro;
	}

	public String getEnd_pes_rua() {
		return end_pes_rua;
	}

	public void setEnd_pes_rua(String end_pes_rua) {
		this.end_pes_rua = end_pes_rua;
	}

	public String getEnd_pes_numero() {
		return end_pes_numero;
	}

	public void setEnd_pes_numero(String end_pes_numero) {
		this.end_pes_numero = end_pes_numero;
	}

	public String getEnd_pes_telefone() {
		return end_pes_telefone;
	}

	public void setEnd_pes_telefone(String end_pes_telefone) {
		this.end_pes_telefone = end_pes_telefone;
	}

	public String getEnd_pes_celular() {
		return end_pes_celular;
	}

	public void setEnd_pes_celular(String end_pes_celular) {
		this.end_pes_celular = end_pes_celular;
	}

	public String getEnd_pes_email() {
		return end_pes_email;
	}

	public void setEnd_pes_email(String end_pes_email) {
		this.end_pes_email = end_pes_email;
	}

}
