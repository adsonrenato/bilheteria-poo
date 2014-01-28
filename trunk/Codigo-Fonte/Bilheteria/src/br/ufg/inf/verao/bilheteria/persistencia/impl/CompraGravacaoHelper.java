package br.ufg.inf.verao.bilheteria.persistencia.impl;

import br.ufg.inf.verao.bilheteria.model.Cliente;
import br.ufg.inf.verao.bilheteria.model.Compra;
import br.ufg.inf.verao.bilheteria.model.Evento;
import br.ufg.inf.verao.bilheteria.model.FormaPagamento;
import br.ufg.inf.verao.bilheteria.model.Ingresso;
import br.ufg.inf.verao.bilheteria.persistencia.base.CSVToFile;
import br.ufg.inf.verao.bilheteria.utils.Conversor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CompraGravacaoHelper implements ServiceHelper <Compra>{

    private final String ARQUIVO = "compras.csv";
    private CSVToFile gerenciadorDeArquivo;
    
    public CompraGravacaoHelper(){
       gerenciadorDeArquivo = new CSVToFile(ARQUIVO);
    }
    
    @Override
    public boolean gravarObjeto(Compra compra) {
        if(!gerenciadorDeArquivo.contem(compra.getIngresso().getNumIdentificacao())){
            return gerenciadorDeArquivo.gravarLinha(toLine(compra));
        }else{
            return false;
        }
    }

    @Override
    public void gravarObjetos(List<Compra> compra) {
       for(Compra ocasiao : compra){
           this.gravarObjeto(ocasiao);
       }
    }
    
    @Override
    public Compra getObjetoPorId(int id) {
        String linha = gerenciadorDeArquivo.getLinhaPorId(id);
        if(linha != null){
            Compra resultado = getObject(linha);
            return resultado;
        }else{
            return null;
        }
        
    }

    @Override
    public List<Compra> getTodosObjetos() {
        List<String> listaObjetos = gerenciadorDeArquivo.getLinhas();
        List<Compra> resultado = new ArrayList<Compra>();
        for(String entrada : listaObjetos){
            Compra compra = getObject(entrada);
            resultado.add(compra);
        }
        return resultado;
    }
    
    
    
    private String toLine(Compra i){
        StringBuilder sb = new StringBuilder();
        sb.append(i.getIdCompra());
        sb.append(ServiceHelper.SEPARADOR);
        sb.append(i.getIngresso().getEvento().getIdEvento());
        sb.append(ServiceHelper.SEPARADOR);
        sb.append(i.getIngresso().getSecao());
        sb.append(ServiceHelper.SEPARADOR);
        sb.append(i.getIngresso().getNumIdentificacao());
        sb.append(ServiceHelper.SEPARADOR);
        sb.append(i.getCliente().getIdCliente());
        sb.append(ServiceHelper.SEPARADOR);
        sb.append(i.getTipoPagamento());
        sb.append(ServiceHelper.SEPARADOR);
        sb.append(i.getValorFinal());
        sb.append(ServiceHelper.SEPARADOR);
        sb.append(Conversor.calendarToString(i.getIngresso().getEvento().getData()));
        return sb.toString();
    }
    
    /**
     * Método que lê determinada linha (registro) do arquivo e retorna
     *  a compra cadastrada.
     * 
     * @param line
     * @return 
     */
    private Compra getObject(String line){
        EventoGravacaoHelper gerenciaEventos = new EventoGravacaoHelper();
        IngressoGravacaoHelper gerenciaIngressos = new IngressoGravacaoHelper();
        ClienteGravacaoHelper gerenciaClientes = new ClienteGravacaoHelper();
        
        // Lê a linha como uma compra
        String[] compra = line.split(String.valueOf(ServiceHelper.SEPARADOR));
        
        // Define os atributos da compra
        int id = Integer.parseInt(compra[0]);
        Ingresso ingresso = gerenciaIngressos.getObjetoPorId(Integer.parseInt(compra[3]));
        Cliente cliente = gerenciaClientes.getObjetoPorId(Integer.parseInt(compra[4]));
        FormaPagamento pagamento = FormaPagamento.valueOf(compra[5]);
        float valor = Float.parseFloat(compra[6]);
        Calendar data = Conversor.stringToCalendar(compra[7]);
        
        // Instancia a compra
        Compra resultado = new Compra(id, data, ingresso, pagamento, cliente, valor);
        return resultado;
    }

    @Override
    public boolean remove(Compra compra) {
        return gerenciadorDeArquivo.removerLinha(compra.getIdCompra());
    }
}
