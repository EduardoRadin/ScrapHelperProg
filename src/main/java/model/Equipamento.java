package model;

public class Equipamento {
	private int eqp_id;
	private int cod_pessoa;
	private String eqp_tipo;
	private String eqp_marca;
	private String eqp_modelo;
	private long eqp_num_serie; // Changed from float to long
	private String eqp_estado_entrada;
	
	
	
	public Equipamento(int eqp_id, int cod_pessoa, String eqp_tipo, String eqp_marca, String eqp_modelo,
			long eqp_num_serie, String eqp_estado_entrada) { // Changed float to long
		this.eqp_id = eqp_id;
		this.cod_pessoa = cod_pessoa;
		this.eqp_tipo = eqp_tipo;
		this.eqp_marca = eqp_marca;
		this.eqp_modelo = eqp_modelo;
		this.eqp_num_serie = eqp_num_serie;
		this.eqp_estado_entrada = eqp_estado_entrada;
	}

	public Equipamento() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ID do equipamento: " + eqp_id 
				+ "\nCódigo do Usuário: " + cod_pessoa 
				+ "\nTipo de Equipamento: " + eqp_tipo
				+ "\nMarca do Equipamento: " + eqp_marca 
				+ "\nModelo do Equipamento: " + eqp_modelo 
				+ "\nNúmero de Série: " + eqp_num_serie
				+ "\nEstado de Entrada: " + eqp_estado_entrada;
	}

	public int getEqp_id() {
		return eqp_id;
	}

	public void setEqp_id(int eqp_id) {
		this.eqp_id = eqp_id;
	}

	public int getCod_pessoa() {
		return cod_pessoa;
	}

	public void setCod_pessoa(int cod_pessoa) {
		this.cod_pessoa = cod_pessoa;
	}

	public String getEqp_tipo() {
		return eqp_tipo;
	}

	public void setEqp_tipo(String eqp_tipo) {
		this.eqp_tipo = eqp_tipo;
	}

	public String getEqp_marca() {
		return eqp_marca;
	}

	public void setEqp_marca(String eqp_marca) {
		this.eqp_marca = eqp_marca;
	}

	public String getEqp_modelo() {
		return eqp_modelo;
	}

	public void setEqp_modelo(String eqp_modelo) {
		this.eqp_modelo = eqp_modelo;
	}

	public long getEqp_num_serie() { // Changed from float to long
		return eqp_num_serie;
	}

	public void setEqp_num_serie(long eqp_num_serie) { // Changed from float to long
		this.eqp_num_serie = eqp_num_serie;
	}

	public String getEqp_estado_entrada() {
		return eqp_estado_entrada;
	}

	public void setEqp_estado_entrada(String eqp_estado_entrada) {
		this.eqp_estado_entrada = eqp_estado_entrada;
	}

	
}