/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fila;

/**
 *
 * @author brenn
 */
public class Celula {
    
    private Celula anterior;
    private Object elemento;

    public Celula() {
    }
    
    public Celula(Object elemento) {
        this.elemento = elemento;
    }
    
    public Celula(Celula proximo, Object elemento) {
        this.anterior = proximo;
        this.elemento = elemento;
    }
    
    //Getters and Setters de celula
    public Celula getProximo() {
        return anterior;
    }

    public void setAnterior(Celula proximo) {
        this.anterior = proximo;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    } 
}
