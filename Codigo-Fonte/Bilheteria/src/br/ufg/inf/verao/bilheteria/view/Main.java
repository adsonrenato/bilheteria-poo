package br.ufg.inf.verao.bilheteria.view;


import br.ufg.inf.verao.bilheteria.model.*;
import br.ufg.inf.verao.bilheteria.persistencia.impl.EventoGravacaoHelper;
import br.ufg.inf.verao.bilheteria.persistencia.impl.IngressoGravacaoHelper;
import java.util.Calendar;
/**
 *
 * @author  Gustavo Martins, Jean Lucas, Valéria Maria, Vinícius Caetano.
 */

public class Main {

	public static void main(String[] args) {

		FormaPagamento novaForma = FormaPagamento.CARTAO;
		Secao novaSecao = Secao.AREAEXTRAVIP;
		Calendar data = Calendar.getInstance();
                Comprador novoComprador = new Comprador("Vinicius","1234",
                            "Endereço", "Telefone" );
		Evento evento = new Evento("EventoA","Local",
                                            "Descri��o", data, 3 );
                
		Ingresso ingresso = new Ingresso(136,evento,
                                                    novaSecao);

                IngressoGravacaoHelper gerenciaIngressos = new IngressoGravacaoHelper();
                EventoGravacaoHelper gerenciaEventos = new EventoGravacaoHelper();
                
                gerenciaEventos.gravarObjeto(evento);

                gerenciaIngressos.gravarObjeto(ingresso);

                //                                novoComprador);
		//novaCompra.desconto(novaForma, novaSecao);
		//System.out.println("Pagarei: " +novaCompra.desconto(novaForma,
                  //                  novaSecao));

	}

}

// SimpleDateFormat