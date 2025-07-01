package model;

public class OrdemDeServico {
	private int os_cod;
	private int cod_eqp;
	private int cod_fun;
	private String os_data_entrada;
	private String os_data_conclusao;
	private String os_eqp_status;
	private String os_eqp_problema;
	private float os_orcamento;
	private String os_servico_realizado;
	
	public OrdemDeServico(int os_cod, int cod_eqp, int cod_fun, String os_data_entrada, String os_data_conclusao,
			String os_eqp_status, String os_eqp_problema, float os_orcamento, String os_servico_realizado) {
		this.os_cod = os_cod;
		this.cod_eqp = cod_eqp;
		this.cod_fun = cod_fun;
		this.os_data_entrada = os_data_entrada;
		this.os_data_conclusao = os_data_conclusao;
		this.os_eqp_status = os_eqp_status;
		this.os_eqp_problema = os_eqp_problema;
		this.os_orcamento = os_orcamento;
		this.os_servico_realizado = os_servico_realizado;
	}

	public OrdemDeServico() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Código da OS: " + os_cod 
				+ "\nCódigo do Equipament: " + cod_eqp 
				+ "\nCódigo do Funcionário: " + cod_fun
				+ "\nData de Entrada: " + os_data_entrada 
				+ "\nData de Conclusão: " + os_data_conclusao
				+ "\nStatus de Equipamento: " + os_eqp_status 
				+ "\nProblema do Equipamento: " + os_eqp_problema 
				+ "\nOrçamento da OS: " + os_orcamento 
				+ "\nServiço Realizado: " + os_servico_realizado;
	}

	public int getOs_cod() {
		return os_cod;
	}

	public void setOs_cod(int os_cod) {
		this.os_cod = os_cod;
	}

	public int getCod_eqp() {
		return cod_eqp;
	}

	public void setCod_eqp(int cod_eqp) {
		this.cod_eqp = cod_eqp;
	}

	public int getCod_fun() {
		return cod_fun;
	}

	public void setCod_fun(int cod_fun) {
		this.cod_fun = cod_fun;
	}

	public String getOs_data_entrada() {
		return os_data_entrada;
	}

	public void setOs_data_entrada(String os_data_entrada) {
		this.os_data_entrada = os_data_entrada;
	}

	public String getOs_data_conclusao() {
		return os_data_conclusao;
	}

	public void setOs_data_conclusao(String os_data_conclusao) {
		this.os_data_conclusao = os_data_conclusao;
	}

	public String getOs_eqp_status() {
		return os_eqp_status;
	}

	public void setOs_eqp_status(String os_eqp_status) {
		this.os_eqp_status = os_eqp_status;
	}

	public String getOs_eqp_problema() {
		return os_eqp_problema;
	}

	public void setOs_eqp_problema(String os_eqp_problema) {
		this.os_eqp_problema = os_eqp_problema;
	}

	public float getOs_orcamento() {
		return os_orcamento;
	}

	public void setOs_orcamento(float os_orcamento) {
		this.os_orcamento = os_orcamento;
	}

	public String getOs_servico_realizado() {
		return os_servico_realizado;
	}

	public void setOs_servico_realizado(String os_servico_realizado) {
		this.os_servico_realizado = os_servico_realizado;
	}
	
	
	
}
