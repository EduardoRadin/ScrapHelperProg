package model;

public class Permissao {
	private int id;
	private String per_descricao;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPer_descricao() {
		return per_descricao;
	}
	public void setPer_descricao(String per_descricao) {
		this.per_descricao = per_descricao;
	}
	
	public Permissao() {
	}
	
	public Permissao(int id, String per_descricao) {
		super();
		this.id = id;
		this.per_descricao = per_descricao;
	}
	@Override
	public String toString() {
		return "Permissao id= " + id 
				+ ", per_descricao=" + per_descricao;
	}
	
	
}
