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
    
    public LinkedList(){
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
        return true;
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
    public void addElemento(T elemento, int posicao) {
        if (posicao < 0 || posicao > this.tamanho) {
            throw new IllegalArgumentException("posição inválida");
        } else if (posicao == 0){
            addInicio(elemento);
        } else if (posicao == this.tamanho -1){
            addFim(elemento);
        } else {
            Celula nova = new Celula(elemento);
            if (this.tamanho == 0) {
                inicio = nova;
                fim = nova;
                this.tamanho += 1;
            } else {
                Iterador it = new Iterador(this.inicio);
                int i = 0;
                while (it.hasNext()) {
                    if (i != posicao - 1) {
                        it.next();
                        i++;
                    } else {
                        break;
                    }
                }
                Celula anterior = it.getAtual();
                Celula atual = anterior.getProximo();
                
                nova.setProximo(atual);
                anterior.setProximo(nova);
                this.tamanho--;
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
        //verifica se a lista está vazia
        if (this.tamanho == 0){
            System.out.println("Lista vazia");
        //verifica se a lista possui apenas 1 elemento    
        } else if (inicio == fim){
            //remove a item e decrementa
            this.inicio = null;
            this.fim = null;
            this.tamanho --;
        //mais de um elemento
        } else {
            //o primeiro elemento agora é o PRÓXIMO do antigo PRIMEIRO
            this.inicio = this.inicio.getProximo();
            //decremento
            this.tamanho --;
        }
    }
    
    //remove do fim
    public void removeFim(){//***********
        //verifica se a lista está vazia
        if (this.tamanho == 0){
            System.out.println("Lista vazia");
        //verifica se a lista possui apenas 1 elemento    
        } else if (inicio == fim){
            //remove a item e decrementa
            this.inicio = this.fim = null;
            this.tamanho --;
         //mais de um elemento
        } else {
            Iterador it = new Iterador(this.inicio);
            int i = 1;
            while (it.hasNext()){
                if (1 != this.tamanho -1){
                    it.next();
                    i++;
                } else {
                    break;
                }
                fim.setElemento(it.getAtual().getElemento());
                fim.setProximo(null);
                this.tamanho --;
            }
        }
    }
    
    //remove de qualquer posição
    public void remover(int posicao){
        //verifica se a posição é válida
        if (posicao < 0 || posicao >= this.tamanho){
            throw new ArrayIndexOutOfBoundsException("posição inválida");
        //verifica se tem apenas 1 elemento
        } else if (this.inicio == this.fim){
            this.inicio = null;
            this.fim = null;
            this.tamanho --;
        //se a posição for inicial
        } else if (posicao == 0){
            removeInicio();
        //se a posição for final
        } else if (posicao == this.tamanho -1){
            removeFim();
        //qualquer outra posição
        } else {
            //implementando iterador
            Iterador it = new Iterador(this.inicio);
            int i = 0;
            while (it.hasNext()){
                if (i != posicao -1){
                    it.next();
                    i++;
                } else {
                    break;
                }    
            }
            Celula anterior = it.getAtual();
            Celula atual = anterior.getProximo();
            Celula proximo = atual.getProximo();
            
            atual.setProximo(null);
            anterior.setProximo(proximo);
            this.tamanho--;
        }
    }
    
    
    //limpar a lista
    public void limpar(){
        //muda para NULL o INÍCIO e FIM da lista
        this.inicio = null;
        this.fim = null;
    }
}
