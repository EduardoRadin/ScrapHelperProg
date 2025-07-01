package model;

public class EnderecoFun {
	private int id;
    private int codFuncionario;
    private int codTipoEndereco;
    private int codCep;
    private String bairro;
    private String rua;
    private int numero;
    private String telefone;
    private String celular;
    private String email;
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodFuncionario() {
		return codFuncionario;
	}

	public void setCodFuncionario(int codFuncionario) {
		this.codFuncionario = codFuncionario;
	}

	public int getCodTipoEndereco() {
		return codTipoEndereco;
	}

	public void setCodTipoEndereco(int codTipoEndereco) {
		this.codTipoEndereco = codTipoEndereco;
	}

	public int getCodCep() {
		return codCep;
	}

	public void setCodCep(int codCep) {
		this.codCep = codCep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    
    // Construtor
    public EnderecoFun() {}
    
    public EnderecoFun(int id, int codFuncionario, int codTipoEndereco, int codCep,
                       String bairro, String rua, int numero, String telefone, String celular, String email) {
        this.id = id;
        this.codFuncionario = codFuncionario;
        this.codTipoEndereco = codTipoEndereco;
        this.codCep = codCep;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
    }

    @Override
    public String toString() {
        return "EnderecoFun id= " + id +
               ", codFuncionario=" + codFuncionario +
               ", codTipoEndereco=" + codTipoEndereco +
               ", codCep=" + codCep +
               ", bairro='" + bairro + '\'' +
               ", rua='" + rua + '\'' +
               ", numero=" + numero +
               ", telefone='" + telefone + '\'' +
               ", celular='" + celular + '\'' +
               ", email='" + email;
    }
}
