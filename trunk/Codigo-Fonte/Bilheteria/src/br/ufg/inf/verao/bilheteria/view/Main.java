package br.ufg.inf.verao.bilheteria.view;


import br.ufg.inf.verao.bilheteria.model.*;
import br.ufg.inf.verao.bilheteria.persistencia.impl.IngressoGravacaoHelper;
import java.util.Calendar;
/**
 *
 * @author  Gustavo Martins, Jean Lucas, Valéria Maria, Vinícius Caetano.
 */

public class Teste {

	public static void main(String[] args) {

		FormaPagamento novaForma = FormaPagamento.CARTAO;
		Secao novaSecao = Secao.AREAEXTRAVIP;
		Calendar data = Calendar.getInstance();
                Comprador novoComprador = new Comprador("Vinicius","1234",
                            "Endereço", "Telefone" );
		Evento novoEvento = new Evento("EventoA","Local",
                                            "Descri��o", data );
		Ingresso novoIngresso = new Ingresso(123,novoEvento,
                                                    novaSecao);

                IngressoGravacaoHelper gerenciaPessoas = new IngressoGravacaoHelper();
//
                gerenciaPessoas.gravarObjeto(novoIngresso);

                Compra novaCompra = new Compra(data, novoIngresso,novaForma,
                                                novoComprador);
		novaCompra.desconto(novaForma, novaSecao);
		System.out.println("Pagarei: " +novaCompra.desconto(novaForma,
                                    novaSecao));

	}

}

// SimpleDateFormat