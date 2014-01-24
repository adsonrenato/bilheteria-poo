package br.ufg.inf.verao.bilheteria.model;

import java.util.Calendar;

public class Evento {
	
	private String nome;
	private String local;
	private String descricao;
	private Calendar data;
	
	public Evento(String nome, String local, String descricao, Calendar data){
		this.nome = nome;
		this.local = local;
		this.descricao = descricao;
		this.data = data;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}
	
	

}
