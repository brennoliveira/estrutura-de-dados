/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pilha;

/**
 *
 * @author brenn
 */
public class Pilha<T> {
    
    private Celula topo;
    private int tamanho;
    
    //contruttor
    public Pilha(){
        this.topo = null;
        this.tamanho = 0;
    }
    
    //verifica se a pilha é vazia
    public boolean isEmpty(){
        return this.topo == null;
    }
    
    //retorna o tamanho da pilha
    public int tamanho(){
        return this.tamanho;
    }
    
    //limpar todos os elemento da pilha
    public void limpa(){
        this.topo = null;
        this.tamanho = 0;
    }
    
    //add elemento no topo da pilha
    public void push(T elemento){
        Celula nova = new Celula(elemento);
        
        if (this.tamanho == 0){
            this.topo = nova;
            this.tamanho++;
        } else {
            nova.setAnterior(this.topo);
            this.topo = nova;
            this.tamanho++;
        }
    }
    
    //retorna objeto do topo da pilha
    public T top(){
        if (isEmpty()){
            throw new IllegalArgumentException("pilha vazia");
        } else {
            return (T) this.topo.getElemento();
        }
    }
    
    //remove objeto do topo da pilha
    public void pop(){
        if (isEmpty()){
            throw new IllegalArgumentException("pilha vazia");
        } else if (this.tamanho == 1){
            this.topo = null;
            this.tamanho = 0;
        } else {
            Celula anterior = this.topo.getAnterior();
            this.topo = null;
            this.topo = anterior;
            this.tamanho--;
        }
    }
    
    //altera valor do topo da pilha
    public void pull(T elemento){
        pop();
        push(elemento);
    }
    
}
