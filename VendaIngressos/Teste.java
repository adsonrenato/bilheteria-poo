import java.util.Calendar;


public class Teste {

	public static void main(String[] args) {
		
		FormaPagamento novaForma = FormaPagamento.CARTAO;
		Secao novaSecao = Secao.AREACAMAROTEPRIME;
		Calendar data = Calendar.getInstance();
		Evento novoEvento = new Evento("EventoA","Local", "Descri��o", data );
		Ingresso novoIngresso = new Ingresso("123",novoEvento, novaSecao);
		Compra novaCompra = new Compra(data, novoIngresso);
		novaCompra.valor(novaForma, novaSecao);
                System.out.print("Eu sou "+novaSecao+ " e ");
		System.out.printf("pagarei: R$%.2f\n",novaCompra.valor(novaForma, novaSecao));

	}

}
