package br.ufg.inf.verao.bilheteria.model;


public enum Secao {

	AREAVIP(40.0f),
	AREAEXTRAVIP(100.0f),
	AREACAMAROTEPRIME(399.99f);
	
	//campo
	private final float preco;
	
	//Contrutor privado
	private Secao(float preco){
		this.preco = preco;
	}
	
	//Método
	public float getPreco(){
		return preco;
	}
	
}
