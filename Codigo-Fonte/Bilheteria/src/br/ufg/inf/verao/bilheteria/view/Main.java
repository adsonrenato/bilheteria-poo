package br.ufg.inf.verao.bilheteria.view;
import br.ufg.inf.verao.bilheteria.model.*;
import br.ufg.inf.verao.bilheteria.persistencia.impl.ClienteGravacaoHelper;
import br.ufg.inf.verao.bilheteria.persistencia.impl.CompraGravacaoHelper;
import br.ufg.inf.verao.bilheteria.persistencia.impl.EventoGravacaoHelper;
import br.ufg.inf.verao.bilheteria.persistencia.impl.IngressoGravacaoHelper;
import br.ufg.inf.verao.bilheteria.utils.Conversor;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author  Gustavo Martins, Jean Lucas, Valéria Maria, Vinícius Caetano.
 */
public class Main {
	public static void main(String[] args) {
            
            Scanner entrada = new Scanner(System.in);
            int opcao = entrada.nextInt();
            do{
                switch (opcao){
                    exibirMenu();        
                }
                    case 1:
                        cadastrarCliente();
                        break;
                    case 2:
                        cadastrarEvento();
                        break;
                    case 3:
                        realizarCompra();
                        break;
                    case 4:
                        excluirCompra();
                        break;
                    case 5:
                        excluirCliente();
                        break;
                    case 6:
                        qtdIngressosVendidos();
                        break;
                    case 7:
                        importarListaIngressos();
                        break;
                    case 8:
                        importarListaCompras();
                        break;
                    case 9:
                        importarListaClientes();
                        
                }while(opcao != 10);
        }
            
            public void exibirMenu(){
                System.out.println("***BILHETERIA***");
                System.out.println(">Digite a opção desejada:");
                System.out.println("1 - Cadastro de cliente;");
                System.out.println("2 - Cadastro de evento;");
                System.out.println("3 - Realizar compra;");
                System.out.println("4 - Excluir Compra;");
                System.out.println("5 - Excluir cliente;");
                System.out.println("6 - Quantidade de ingressos vendidos;");
                System.out.println("7 - Importar lista de ingressos;");
                System.out.println("8 - Importar lista de compras");
                System.out.println("9 - Importar lista de clientes");
                System.out.println("10 - Sair.");
            }
            
            public void cadastrarCliente(){
                
                Scanner entrada = new Scanner(System.in);
                
                System.out.println("**CADASTRO DO CLIENTE**");
                System.out.println("Id: ");
                int idCliente = Integer.parseInt(entrada.nextLine().trim());
                System.out.println("Nome: ");
                String nome = entrada.nextLine();
                System.out.println("CPF: ");
                String cpf = entrada.nextLine();
                System.out.println("Endereço: ");
                String endereco = entrada.nextLine();
                System.out.println("CEP: ");
                String cep = entrada.nextLine();
                System.out.println("Telefone: ");
                String telefone = entrada.nextLine();
                
                Cliente cliente = new Cliente(idCliente, nome, cpf, 
                                            endereco, cep, telefone);
                ClienteGravacaoHelper gravaCliente = 
                        new ClienteGravacaoHelper();
            }
            
            public void cadastrarEvento(){
                
                Scanner entrada = new Scanner(System.in);
                
                System.out.println("**CADASTRO DO EVENTO**");
                System.out.println("Id: ");
                int idEvento = Integer.parseInt(entrada.nextLine().trim());
                System.out.println("Nome: ");
                String nome = entrada.nextLine();
                System.out.println("Local: ");
                String local = entrada.nextLine();
                System.out.println("Descrição: ");
                String descricao = entrada.nextLine();
                System.out.println("Data (dd/mm/aa): ");
                String str_data = entrada.nextLine();
                Calendar data = Conversor.stringToCalendar(str_data);
                
                Evento evento = new Evento(idEvento, nome,local,descricao,data);

                EventoGravacaoHelper gravaEvento = new EventoGravacaoHelper();
            }
             
            public void realizarCompra(){
                Scanner entrada = new Scanner(System.in);

                //Calendar data = Calendar.getInstance();
                System.out.println("**REALIZAR COMPRA**");
                System.out.println("Id da compra: ");
                int idCompra = entrada.nextInt();
                System.out.println("Id do evento: ");
                int idEvento = entrada.nextInt();
                System.out.println("Id do cliente: ");
                int idCliente = entrada.nextInt();
                System.out.println("Tipo de seção "
                        + "(AREAVIP,AREAEXTRAVIP ou AREACAMAROTEPRIME");
                System.out.println("Forma de pagamento (Dinheiro ou Cartão)");
                Compra compra = new Compra(idCompra, data, idEvento, idCliente,
                qtdIngressos, opcaoSecao, opcaoPag);

            }
}
// SimpleDateFormat