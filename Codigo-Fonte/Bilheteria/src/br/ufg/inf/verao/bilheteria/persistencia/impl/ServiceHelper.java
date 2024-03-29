/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.verao.bilheteria.persistencia.impl;

import java.util.List;

/**
 *
 * @author marceloquinta
 */
public interface ServiceHelper <T extends Object>{
    
    public static final char SEPARADOR = ';';
    
    public boolean gravarObjeto(T object);
    public void gravarObjetos(List<T> object);
    public T getObjetoPorId(int id);
    public List<T> getTodosObjetos();
    public boolean remove(T Object);
}
