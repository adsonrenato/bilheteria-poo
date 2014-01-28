package br.ufg.inf.verao.bilheteria.persistencia.impl;

import br.ufg.inf.verao.bilheteria.model.Cliente;
import br.ufg.inf.verao.bilheteria.persistencia.base.CSVToFile;
import java.util.ArrayList;
import java.util.List;

public class ClienteGravacaoHelper implements ServiceHelper <Cliente>{

    private final String ARQUIVO = "clientes.csv";
    private CSVToFile gerenciadorDeArquivo;
    
    public ClienteGravacaoHelper(){
       gerenciadorDeArquivo = new CSVToFile(ARQUIVO);
    }
    
    @Override
    public boolean gravarObjeto(Cliente cliente) {
        if(!gerenciadorDeArquivo.contem(cliente.getIdCliente())){
            return gerenciadorDeArquivo.gravarLinha(toLine(cliente));
        }else{
            return false;
        }
    }

    @Override
    public void gravarObjetos(List<Cliente> cliente) {
       for(Cliente comprador : cliente){
           this.gravarObjeto(comprador);
       }
    }
    
    @Override
    public Cliente getObjetoPorId(int id) {
        String linha = gerenciadorDeArquivo.getLinhaPorId(id);
        if(linha != null){
            Cliente resultado = getObject(linha);
            return resultado;
        }else{
            return null;
        }
        
    }

    @Override
    public List<Cliente> getTodosObjetos() {
        List<String> listaObjetos = gerenciadorDeArquivo.getLinhas();
        List<Cliente> resultado = new ArrayList<Cliente>();
        for(String entrada : listaObjetos){
            Cliente cliente = getObject(entrada);
            resultado.add(cliente);
        }
        return resultado;
    }
    
    
    
    private String toLine(Cliente i){
        StringBuilder sb = new StringBuilder();
        
        sb.append(i.getIdCliente());
        sb.append(ServiceHelper.SEPARADOR);
        sb.append(i.getCpf());
        sb.append(ServiceHelper.SEPARADOR);
        sb.append(i.getNome());
        sb.append(ServiceHelper.SEPARADOR);
        sb.append(i.getEndereco());
        sb.append(ServiceHelper.SEPARADOR);
        sb.append(i.getTelefone());
        return sb.toString();
    }
    
    private Cliente getObject(String line){
        String[] cliente = line.split(
                String.valueOf(ServiceHelper.SEPARADOR));
        int id = Integer.parseInt(cliente[0]);
        
        Cliente resultado = new Cliente(id);
        return resultado;
    }

    @Override
    public boolean remove(Cliente cliente) {
        return gerenciadorDeArquivo.removerLinha(cliente.getIdCliente());
    }
}
