package br.ufg.inf.verao.bilheteria.model;

import java.util.Calendar;


public class Compra {

	private Calendar dataCompra;
	private Ingresso ingresso;
	private FormaPagamento tipoPagamento;
	private Comprador comprador;
        private float valorFinal;
        
        private final float PRECO_MIN_DESCONTO = 50.0f;
        private final int MENOR_DESCONTO = 1;
        private final int TOTAL_PORCENTAGEM = 1;

	public Compra(Calendar dataCompra, Ingresso ingresso, 
                FormaPagamento tipoPagamento, Comprador comprador){
		this.dataCompra = dataCompra;
		this.ingresso = ingresso;
                this.tipoPagamento = tipoPagamento;
                this.comprador = comprador;

                valorFinal = calcularValorFinal();
	}
	
	public Ingresso getIngresso() {
		return ingresso;
	}

	public void setIngresso(Ingresso ingresso) {
		this.ingresso = ingresso;
	}

	public Calendar getDataCompra() {
		return dataCompra;
	}
	
	public FormaPagamento getTipoPagamento() {
		return tipoPagamento;
	}
	
	public void setTipoPagamento(FormaPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	
	public Comprador getComprador() {
		return comprador;
	}

	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}

    public float getValorFinal() {
        return valorFinal;
    }



	private float calcularValorFinal (){
		float pagar;
                if((ingresso.getSecao().getPreco() < PRECO_MIN_DESCONTO) && 
                        (tipoPagamento == FormaPagamento.DINHEIRO)){
                    pagar = ingresso.getSecao().getPreco() - MENOR_DESCONTO;
                }
                else{
                    pagar = ingresso.getSecao().getPreco()*(TOTAL_PORCENTAGEM - 
                            tipoPagamento.getDesconto());
                }
                return pagar;
		
	}
}
