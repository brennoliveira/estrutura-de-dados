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
public class Fila<T> {
    private Celula primeiro, ultimo;
    private int tamanho;
    
    public Fila(){
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }
    
    //retornar tamanho da fila
    public int tamanho(){
        return this.tamanho;
    }
    
    //verificar se a fila é vazia
    public boolean isEmpty(){
        return this.primeiro == null && this.tamanho == 0 && this.ultimo == null;
    }
    
    //retornar o último elemento
    public Object getUltimo(){
        return this.ultimo.getElemento();
    }
    
    //retornar o primeiro elemento
    public Object getPrimeiro(){
        return this.primeiro.getElemento();
    }
    
    //limpar todos os elementos
    public void limpar(){
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }
    
    //adicionar um elemento no fim da fila
    public void inserir(T elemento){
        Celula nova = new Celula(elemento);
        
        if (this.tamanho == 0){
            this.primeiro = nova;
            this.ultimo = nova;
            this.tamanho++;
        } else {
            this.ultimo.setAnterior(nova);
            this.ultimo = nova;
            this.tamanho++;
        }
    }
    
    //recuperar um elemento do início da fila
    public T recupera(){
        if (this.tamanho == 0){
            throw new IllegalArgumentException("fila vazia");
        } else {
            return (T) this.primeiro.getElemento();
        }
    }
    //remover um elemento do início da fila
    public void remover(){
        if (this.tamanho == 0){
            throw new IllegalArgumentException("fila vazia");
        } else if (this.tamanho == 1) {
            limpar();
        } else {
            Celula proximo = this.primeiro.getProximo();
            this.primeiro.setAnterior(null);
            this.primeiro = proximo;
            this.tamanho--;
        }
        
    }
    
    //alterar um valor no inicio da fila
    public void alterar(T elemento){
        Celula nova = new Celula(elemento);
        
        if (this.tamanho == 0){
            throw new IllegalArgumentException("fila vazia");
        } else if (this.tamanho == 1){
            this.primeiro.setAnterior(null);
            this.primeiro = nova;
        } else {
            Celula proximo = this.primeiro.getProximo();
            this.primeiro.setAnterior(null);
            this.primeiro = nova;
            this.primeiro.setAnterior(proximo);
        }
    }
    
}
