import java.util.Calendar;


public class Compra {

	private Calendar dataCompra;
	private Ingresso ingresso;
	private FormaPagamento tipoPagamento;
	private Comprador comprador;

	public Compra(Calendar dataCompra, Ingresso ingresso){
		this.dataCompra = dataCompra;
		this.ingresso = ingresso;
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
	
	public float valor (FormaPagamento novaForma, Secao novaSecao){
		float pagar;
		if(novaForma == FormaPagamento.DINHEIRO){
			if(novaSecao.getPreco() > 50.0f)
				pagar = novaSecao.getPreco() * 0.98f;
			else 
				pagar = novaSecao.getPreco() - 1;
		}else{
                    pagar = novaSecao.getPreco();
                }
		return pagar;
	}
}
