/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaDuplamenteEncadeada;

/**
 *
 * @author brenn
 */
public class Celula {
    
    private Celula anterior;
    private Celula proximo;
    private Object elemento;
    
    public Celula(){
        
    }
    
    public Celula(Object elemento){
        this.elemento = elemento;
    }
    
    public Celula(Celula anterior, Celula proximo, Object elemento){
        this.anterior = anterior;
        this.proximo = proximo;
        this.elemento = elemento;
    }

    public Celula getAnterior() {
        return anterior;
    }

    public void setAnterior(Celula anterior) {
        this.anterior = anterior;
    }

    public Celula getProximo() {
        return proximo;
    }

    public void setProximo(Celula proximo) {
        this.proximo = proximo;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }
    
    
    
}
