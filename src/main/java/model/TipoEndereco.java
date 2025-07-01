package model;

public class TipoEndereco {
	private int tip_end_cod;
	private String tip_end_descricao;
	
	public TipoEndereco(int tip_end_cod, String tip_end_descricao) {
		this.tip_end_cod = tip_end_cod;
		this.tip_end_descricao = tip_end_descricao;
	}

	public TipoEndereco() {
	}

	public String toString() {
		return "Tipo do Endereço: " + tip_end_cod 
				+ "\nDescrição do Tipo de Endereço: " + tip_end_descricao;
	}

	public int getTip_end_cod() {
		return tip_end_cod;
	}

	public void setTip_end_cod(int tip_end_cod) {
		this.tip_end_cod = tip_end_cod;
	}

	public String getTip_end_descricao() {
		return tip_end_descricao;
	}

	public void setTip_end_descricao(String tip_end_descricao) {
		this.tip_end_descricao = tip_end_descricao;
	}

}
