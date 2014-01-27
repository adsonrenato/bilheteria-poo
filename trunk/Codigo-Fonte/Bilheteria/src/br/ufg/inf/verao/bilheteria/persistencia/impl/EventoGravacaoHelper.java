package br.ufg.inf.verao.bilheteria.persistencia.impl;

import br.ufg.inf.verao.bilheteria.model.Evento;
import br.ufg.inf.verao.bilheteria.persistencia.base.CSVToFile;
import java.util.ArrayList;
import java.util.List;

public class EventoGravacaoHelper implements ServiceHelper <Evento>{

    private final String ARQUIVO = "eventos.csv";
    private CSVToFile gerenciadorDeArquivo;
    
    public EventoGravacaoHelper(){
       gerenciadorDeArquivo = new CSVToFile(ARQUIVO);
    }
    
    @Override
    public boolean gravarObjeto(Evento evento) {
        if(!gerenciadorDeArquivo.contem(evento.getIdEvento())){
            return gerenciadorDeArquivo.gravarLinha(toLine(evento));
        }else{
            return false;
        }
    }

    @Override
    public void gravarObjetos(List<Evento> evento) {
       for(Evento ocasiao : evento){
           this.gravarObjeto(ocasiao);
       }
    }
    
    @Override
    public Evento getObjetoPorId(int id) {
        String linha = gerenciadorDeArquivo.getLinhaPorId(id);
        if(linha != null){
            Evento resultado = getObject(linha);
            return resultado;
        }else{
            return null;
        }
        
    }

    @Override
    public List<Evento> getTodosObjetos() {
        List<String> listaObjetos = gerenciadorDeArquivo.getLinhas();
        List<Evento> resultado = new ArrayList<Evento>();
        for(String entrada : listaObjetos){
            Evento evento = getObject(entrada);
            resultado.add(evento);
        }
        return resultado;
    }
    
    
    
    private String toLine(Evento i){
        StringBuilder sb = new StringBuilder();
        sb.append(i.getNome());
        sb.append(ServiceHelper.SEPARADOR);
        sb.append(i.getDescricao());
        sb.append(ServiceHelper.SEPARADOR);
        sb.append(i.getLocal());
        sb.append(ServiceHelper.SEPARADOR);
        sb.append(i.getIdEvento());
        return sb.toString();
    }
    
    private Evento getObject(String line){
        String[] evento = line.split(
                String.valueOf(ServiceHelper.SEPARADOR));
        int id = Integer.parseInt(evento[0]);
        
        Evento resultado = new Evento(id);
        return resultado;
    }

    @Override
    public boolean remove(Evento evento) {
        return gerenciadorDeArquivo.removerLinha(evento.getIdEvento());
    }
}
