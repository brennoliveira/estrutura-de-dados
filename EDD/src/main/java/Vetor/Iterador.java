/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edd;

import java.util.Iterator;

public class Iterador<T> implements Iterator {

    T[] itens;
    int posicao = 0;

    //Construtor do iterador
    public Iterador(T[] itens) {
        this.itens = itens;
    }

    //Verifica se ainda possui dados
    public boolean hasNext() {
        if (posicao < 0 || posicao >= itens.length) {
            return false;
        } else {
            return true;
        }
    }

    //retorna o próximo valor 
    public Object next() {
        Object item = itens[posicao];
        posicao++;
        return item;
    }
}
