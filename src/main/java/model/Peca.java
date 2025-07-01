package model;

public class Peca {
	private int peca_id;
	private String peca_nome;
	private String peca_descricao;
	private float peca_preco;
	
	public Peca(int peca_id, String peca_nome, String peca_descricao, float peca_preco) {
		this.peca_id = peca_id;
		this.peca_nome = peca_nome;
		this.peca_descricao = peca_descricao;
		this.peca_preco = peca_preco;
	}

	public Peca() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ID da Peca:" + peca_id 
				+ "\nNome da Peça: " + peca_nome 
				+ "\nDescrição da Peça: " + peca_descricao
				+ "\nPreço da Peça: " + peca_preco;
	}

	public int getPeca_id() {
		return peca_id;
	}

	public void setPeca_id(int peca_id) {
		this.peca_id = peca_id;
	}

	public String getPeca_nome() {
		return peca_nome;
	}

	public void setPeca_nome(String peca_nome) {
		this.peca_nome = peca_nome;
	}

	public String getPeca_descricao() {
		return peca_descricao;
	}

	public void setPeca_descricao(String peca_descricao) {
		this.peca_descricao = peca_descricao;
	}

	public float getPeca_preco() {
		return peca_preco;
	}

	public void setPeca_preco(float peca_preco) {
		this.peca_preco = peca_preco;
	}

	
	
}
