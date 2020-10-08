/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaEncadeada;

/**
 *
 * @author brenn
 */
public class LinkedList<T> {
    private Celula inicio, fim;
    private int tamanho;
    
    public LinkedList(int tamanho){
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }
    
    //tamanho da lista
    public int tamanho(){
        return tamanho;
    }
    
    //verificar se existe dado
    public boolean existeDado(int posicao){
        return false;
    }
    
    //adicionar elemento no ínicio da lista
    public void addInicio(T elemento){ //FUNCIONANDO
        //nova celula
        Celula nova = new Celula(elemento);
        //verifica se a lista é vazia
        if (this.tamanho == 0){
            inicio = fim = nova;
            this.tamanho += 1;
        //add elemento no inicio
        } else {
            nova.setProximo(inicio);
            inicio = nova;
            this.tamanho += 1;
        }    
    }
    
    //adiciona no fim da lista
    public void addFim(T elemento){//Funcionando
        //nova celula
        Celula nova = new Celula(elemento);
        //verificando se a lista é vazia
        if ( tamanho == 0){
            this.addInicio(elemento);
            inicio = nova;
            fim = nova;
            tamanho++;
        //add elemento no fim
        } else{
            nova.setProximo(null);
            fim.setProximo(nova);
            fim = nova;
            tamanho++;
        }
    }
    
    //adicionar elemento em qualquer posição da lista
    public void addElemento(T elemento, int posicao){
        //nova celula
        Celula nova = new Celula(elemento);
        //verificando se a lista é vaiz OU a posição é inicial
        if (this.tamanho == 0 && posicao == 0){
            addInicio(elemento);
        //verificando se a posição é final
        } else if (posicao == this.tamanho -1){
            addFim(elemento);
        //implementando iterador
        } else {
            Iterador it = new Iterador(nova);
            int i = 0;
            while (it.hasNext()){
                if (i != posicao){
                    it.next();
                    i++;
                } else {
                    break;
                }
            }
            
        }
            
        
    }
  
    
    
    //retorna um valor da lista usando ITERADOR
    public T Recupera(int posicao) {
        
        if (this.tamanho == 0) {
            
            System.out.println("A lista está vazia!!");
            return null;
            
        } else if (posicao < 0 || posicao >= this.tamanho) {
            
            System.out.println("A Posição " + posicao + " é Inválida!");
            return null;
            
        } else {
            
            Iterador it = new Iterador(this.inicio);
            int i = 0;
            while (it.hasNext()) {
                if (i != posicao) {
                    it.next();
                    i++;
                } else {
                    break;
                }
            }
            
            return (T) it.getAtual().getElemento();
        }
    }
    
    //remover do início
    public void removeInicio(){
        if (this.tamanho == 0){
            System.out.println("Lista vazia");
        } else if (inicio == fim){
            this.tamanho --;
        } else {
            inicio = inicio.getProximo();
            this.tamanho --;
        }
    }
    
    //verifica se o dado existe na lista
    public void existeDado(T elemento){
        
        if (tamanho == 0){
            System.out.println("Elemento não existe");
        } else {
           
        }
    }
}
