package br.ufg.inf.verao.bilheteria.model;


public class Cliente {

	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;
        private int idCliente;

    
 
       public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }
	
	public Cliente(String nome, String cpf, String endereco, String telefone){
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
        
        public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}