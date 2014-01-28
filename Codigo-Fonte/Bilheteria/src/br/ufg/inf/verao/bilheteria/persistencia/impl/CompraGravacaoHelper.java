package br.ufg.inf.verao.bilheteria.persistencia.impl;

import br.ufg.inf.verao.bilheteria.model.Compra;
import br.ufg.inf.verao.bilheteria.persistencia.base.CSVToFile;
import java.util.ArrayList;
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
        sb.append(i.getCliente().getNome());
        sb.append(ServiceHelper.SEPARADOR);
        sb.append(i.getCliente().getCpf());
        sb.append(ServiceHelper.SEPARADOR);
        sb.append(i.getIngresso().getNumIdentificacao());
        sb.append(ServiceHelper.SEPARADOR);
        sb.append(i.getTipoPagamento());
        sb.append(ServiceHelper.SEPARADOR);
        sb.append(i.getValorFinal());
        return sb.toString();
    }
    
    private Compra getObject(String line){
        String[] compra = line.split(
                String.valueOf(ServiceHelper.SEPARADOR));
        int id = Integer.parseInt(compra[0]);
        
        Compra resultado = new Compra(id);
        return resultado;
    }

    @Override
    public boolean remove(Compra compra) {
        return gerenciadorDeArquivo.removerLinha(compra.getIdCompra());
    }
}
