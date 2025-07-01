package model;

public class OSPecaUtilizada {
	private int peca_id;
	private int cod_os;
	private int quantidade;
	
	public OSPecaUtilizada(int peca_id, int cod_os, int quantidade) {
		this.peca_id = peca_id;
		this.cod_os = cod_os;
		this.quantidade = quantidade;
	}

	public OSPecaUtilizada() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ID da Peça: " + peca_id 
				+ "\nCódigo da OS: " + cod_os 
				+ "\nQuantidade: " + quantidade;
	}

	public int getPeca_id() {
		return peca_id;
	}

	public void setPeca_id(int peca_id) {
		this.peca_id = peca_id;
	}

	public int getCod_os() {
		return cod_os;
	}

	public void setCod_os(int cod_os) {
		this.cod_os = cod_os;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
