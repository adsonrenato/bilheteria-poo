package br.ufg.inf.verao.bilheteria.model;

public class Ingresso {

	private int numIdentificacao;
	private Evento evento;
	private Secao secao;


	public Ingresso(int numIdentificacao){
		this.numIdentificacao = numIdentificacao;
	}
        
	public Ingresso(int numIdentificacao, Evento evento, Secao secao){
		this.numIdentificacao = numIdentificacao;
		this.evento = evento;
		this.secao = secao;
	}
	
	public int getNumIdentificacao() {
		return numIdentificacao;
	}
	
	public void setNumIdentificacao(int numIdentificacao) {
		this.numIdentificacao = numIdentificacao;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	public Secao getSecao() {
		return secao;
	}

	public void setSecao(Secao secao) {
		this.secao = secao;
	}
        
      
}
