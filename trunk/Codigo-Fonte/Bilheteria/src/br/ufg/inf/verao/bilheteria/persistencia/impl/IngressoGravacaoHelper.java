package br.ufg.inf.verao.bilheteria.persistencia.impl;

import br.ufg.inf.verao.bilheteria.model.Evento;
import br.ufg.inf.verao.bilheteria.model.Ingresso;
import br.ufg.inf.verao.bilheteria.model.Secao;
import br.ufg.inf.verao.bilheteria.persistencia.base.CSVToFile;
import java.util.ArrayList;
import java.util.List;

public class IngressoGravacaoHelper implements ServiceHelper<Ingresso>{

    private final String ARQUIVO = "ingressos.csv";
    private CSVToFile gerenciadorDeArquivo;
    
    public IngressoGravacaoHelper(){
       gerenciadorDeArquivo = new CSVToFile(ARQUIVO);
    }
    
    @Override
    public boolean gravarObjeto(Ingresso ingresso) {
        if(!gerenciadorDeArquivo.contem(ingresso.getNumIdentificacao())){
            return gerenciadorDeArquivo.gravarLinha(toLine(ingresso));
        }else{
            return false;
        }
    }

    @Override
    public void gravarObjetos(List<Ingresso> ingresso) {
       for(Ingresso individuo : ingresso){
           this.gravarObjeto(individuo);
       }
    }
    
    @Override
    public Ingresso getObjetoPorId(int id) {
        String linha = gerenciadorDeArquivo.getLinhaPorId(id);
        if(linha != null){
            Ingresso resultado = getObject(linha);
            return resultado;
        }else{
            return null;
        }
        
    }

    @Override
    public List<Ingresso> getTodosObjetos() {
        List<String> listaObjetos = gerenciadorDeArquivo.getLinhas();
        List<Ingresso> resultado = new ArrayList<Ingresso>();
        for(String entrada : listaObjetos){
            Ingresso ingresso = getObject(entrada);
            resultado.add(ingresso);
        }
        return resultado;
    }
    
    
    
    private String toLine(Ingresso i){
        StringBuilder sb = new StringBuilder();
        sb.append(i.getNumIdentificacao());
        sb.append(ServiceHelper.SEPARADOR);
        sb.append(i.getEvento().getIdEvento());
        sb.append(ServiceHelper.SEPARADOR);
        sb.append(i.getSecao());
        return sb.toString();
    }
    
    private Ingresso getObject(String line){
        EventoGravacaoHelper gerenciaEventos = new EventoGravacaoHelper();
        
        String[] ingresso = line.split(String.valueOf(ServiceHelper.SEPARADOR));
        
        int id = Integer.parseInt(ingresso[0]);
        Evento evento = gerenciaEventos.getObjetoPorId(Integer.parseInt(ingresso[1]));
        Secao secao = Secao.valueOf(ingresso[2]);
        
        Ingresso resultado = new Ingresso(id, evento, secao);
        return resultado;
    }

    @Override
    public boolean remove(Ingresso ingresso) {
        return gerenciadorDeArquivo.removerLinha(ingresso.getNumIdentificacao());
    }
}
