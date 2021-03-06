/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pilha;

import java.util.Iterator;

/**
 *
 * @author brenn
 */
public class Iterador<T> implements Iterator {
    
    private Celula atual;
    
    public Iterador(Celula atual){
        this.atual = atual;
    }
    
    @Override
    public boolean hasNext(){
        if (atual != null){
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public Object next(){
        T elemento = (T) atual.getElemento();
        atual = atual.getAnterior();
        return elemento;
    }
    
    public Celula getAtual(){
        return atual;
    }
    
}
