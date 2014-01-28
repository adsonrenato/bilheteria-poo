package br.ufg.inf.verao.bilheteria.view;
import br.ufg.inf.verao.bilheteria.model.*;
import br.ufg.inf.verao.bilheteria.persistencia.impl.ClienteGravacaoHelper;
import br.ufg.inf.verao.bilheteria.persistencia.impl.CompraGravacaoHelper;
import br.ufg.inf.verao.bilheteria.persistencia.impl.EventoGravacaoHelper;
import br.ufg.inf.verao.bilheteria.persistencia.impl.IngressoGravacaoHelper;
import java.util.Calendar;
import java.util.List;
/**
 *
 * @author  Gustavo Martins, Jean Lucas, Valéria Maria, Vinícius Caetano.
 */
public class Main {
	public static void main(String[] args) {
		FormaPagamento novaForma = FormaPagamento.CARTAO;
		Secao novaSecao = Secao.AREAEXTRAVIP;
		Calendar data = Calendar.getInstance();
                Cliente novoComprador = new Cliente(1,"Vinicius","1234", "Endereço", "Telefone" );
		Evento evento = new Evento(1, "EventoA","Local", "Descrição", data);
                Evento evento2 = new Evento(2, "Evento2","Local", "Descrição", data);
                Ingresso ingresso = new Ingresso(136,evento2, novaSecao);
                Compra compra = new Compra(23, data, ingresso, novaForma, novoComprador);
		
                IngressoGravacaoHelper gerenciaIngressos = new IngressoGravacaoHelper();
                EventoGravacaoHelper gerenciaEventos = new EventoGravacaoHelper();
                CompraGravacaoHelper gerenciaCompras = new CompraGravacaoHelper();
                ClienteGravacaoHelper gerenciaClientes = new ClienteGravacaoHelper();
                
                gerenciaEventos.gravarObjeto(evento);
                gerenciaEventos.gravarObjeto(evento2);
                gerenciaIngressos.gravarObjeto(ingresso);
                gerenciaCompras.gravarObjeto(compra);
                gerenciaClientes.gravarObjeto(novoComprador);
                
                List x = gerenciaCompras.getTodosObjetos();
                System.out.println("oi");
                //                                novoComprador);
		//novaCompra.desconto(novaForma, novaSecao);
		//System.out.println("Pagarei: " +novaCompra.desconto(novaForma,
                  //                  novaSecao));
	}
}
// SimpleDateFormat