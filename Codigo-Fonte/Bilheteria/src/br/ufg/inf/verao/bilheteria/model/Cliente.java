package br.ufg.inf.verao.bilheteria.model;


public class Cliente {

	private String nome;
	private String cpf;
	private String endereco;
        private String cep;
	private String telefone;
        private int idCliente;

    
 
       public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }
	
	public Cliente(int idCliente, String nome, String cpf, String endereco,String cep, String telefone){
                this.idCliente = idCliente;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
                this.cep = cep;
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

}
