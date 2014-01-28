package br.ufg.inf.verao.bilheteria.model;

import java.util.Calendar;


public class Compra {

	private Calendar dataCompra;
	private Ingresso ingresso;
	private FormaPagamento tipoPagamento;
	private Cliente cliente;
        private float valorFinal;
        private int idCompra;
        
        private final float PRECO_MIN_DESCONTO = 50.0f;
        private final int MENOR_DESCONTO = 1;
        private final int TOTAL_PORCENTAGEM = 1;
        
        public Compra(int idCompra){
            this.idCompra = idCompra;
        }
        
	public Compra(int idCompra, Calendar dataCompra, Ingresso ingresso, 
                FormaPagamento tipoPagamento, Cliente comprador){
                this.idCompra = idCompra;
		this.dataCompra = dataCompra;
		this.ingresso = ingresso;
                this.tipoPagamento = tipoPagamento;
                this.cliente = comprador;

                valorFinal = calcularValorFinal();
	}
        
        public Compra(int idCompra, Calendar dataCompra, Ingresso ingresso, 
                FormaPagamento tipoPagamento, Cliente comprador, float valorFinal){
                this.idCompra = idCompra;
		this.dataCompra = dataCompra;
		this.ingresso = ingresso;
                this.tipoPagamento = tipoPagamento;
                this.cliente = comprador;

                this.valorFinal = valorFinal;
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
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente comprador) {
		this.cliente = cliente;
	}

        public float getValorFinal() {
            return valorFinal;
        }

        public int getIdCompra() {
            return idCompra;
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
