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
public class DoublyLinkedList<T> {

    //variáveis iniciais
    private Celula inicio, fim;
    private int tamanho;

    //construtor
    public DoublyLinkedList() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }
    
    public int tamanho(){
        return this.tamanho;
    }
    
    public boolean existeDado(T elemento){
        return true;
    }
    
    public void limpar(){
        this.fim = this.inicio = null;
        this.tamanho = 0;
    }
    
    //adicione elemento no início
    public void addInicio(T elemento){
        Celula nova = new Celula(elemento);
        if (this.tamanho == 0){
            this.inicio = this.fim = nova;
            this.tamanho++;
        } else {
            nova.setProximo(inicio);
            nova.setAnterior(null);
            inicio = nova;
            
            Celula proximo = inicio.getProximo();
            proximo.setAnterior(inicio);
            this.tamanho++;
        }
    }
    //adiciona no fim da lista
    public void addFim(T elemento){
        Celula nova = new Celula(elemento);
        if (this.tamanho == 0){
            this.inicio = this.fim = nova;
            this.tamanho++;
        } else {
            fim.setProximo(nova);
            nova.setAnterior(fim);
            nova.setProximo(null);
            fim = nova;
            this.tamanho++;
        }
        
    }
    
    public T recupera(int posicao){
        if (this.tamanho == 0){
            throw new IllegalArgumentException("posição inválida");
        } else if (posicao < 0 || posicao >= this.tamanho) {
            throw new IllegalArgumentException("Essa posição não existe na lista duplamente encadeada");
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
    
    public void removeInicio(){
        if (this.tamanho == 0) {
            throw new IllegalArgumentException("posição inválida");
        } else if (this.inicio == this.fim) {
            this.inicio = this.fim = null;
            this.tamanho--;
        } else {
           Celula proximo = this.inicio.getProximo();
           this.inicio.setProximo(null);
           this.inicio.setAnterior(null);
           this.inicio = proximo;
           
           this.tamanho--;
        }      
    }
    
    public void removeFim(){
        if (this.tamanho == 0) {
            throw new IllegalArgumentException("posição inválida");
        } else if (inicio == fim) {
            inicio = null;
            fim = null;
            this.tamanho -= 1;
        } else {
            Iterador it = new Iterador(this.inicio);
            int i = 1;
            while (it.hasNext()) {
                if (i != tamanho - 1) {
                    it.next();
                    i++;
                } else {
                    break;
                }
            }
            Celula atual = it.getAtual();
            Celula anterior = atual.getAnterior();
            this.fim.setElemento(atual);
            this.fim.setProximo(null);
            this.fim.setAnterior(anterior);
            this.tamanho--;
        }
    }
    public void remove(int posicao) {
        if (posicao < 0 || posicao >= tamanho()) {//validação da posição
            throw new IllegalArgumentException("posição inválida");
            
        } else if (this.inicio == this.fim) {//se a lista tiver 1 elemento
            this.inicio = this.fim = null;
            this.tamanho--;
            
        } else if (posicao == 0) {//se for escolhida a posição inicial
            removeInicio();
        } else {
            Iterador it = new Iterador(this.inicio);//implementando o iterador
            int i = 0;
            while (it.hasNext()) {
                if (i != posicao - 1) {
                    it.next();
                    i++;
                } else {
                    break;
                }
            }//criando as células base para as trocas
            Celula anterior = it.getAtual();
            Celula atual = anterior.getProximo();
            Celula proximo = atual.getProximo();
            
            if (posicao == tamanho()) {//se for a posição final
                removeFim();
            } else {//qualquer outra posição
                atual.setAnterior(null);
                atual.setProximo(null);
                proximo.setAnterior(anterior);
                anterior.setProximo(proximo);
               
                this.tamanho--;
            }
        }
    }
    
    //adiciona em qualquer posição da lista
    public void adiciona(T elemento, int posicao) {
        if (posicao < 0 || posicao > this.tamanho) {
            throw new IllegalArgumentException("Essa posição não existe na lista duplamente encadeada");
        } else {
            Celula nova = new Celula(elemento);
            if (this.tamanho == 0) {
                addInicio(elemento);
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
                if (posicao == 0){
                    addInicio(elemento);
                    
                } else if (posicao == tamanho()){
                    addFim(elemento);
                    
                } else {
                    Celula anterior = it.getAtual();//anterior
                    Celula atual = anterior.getProximo();//atual
                    
                    nova.setAnterior(anterior);
                    nova.setProximo(atual);
                    
                    anterior.setProximo(nova);
                    atual.setAnterior(nova);
                    
                    this.tamanho++;
                }
            }
        }
    }
    
    public void trocaPosicao(int posicao){
        if (posicao < 0 || posicao > this.tamanho){//verificando se a posição é válida
            throw new IllegalArgumentException("posição inválida");
            
        } else if (posicao == 0) {//se foi selecionado a posição inicial
            T a = recupera(posicao);//clona a célula da posição
            addFim(a);//adiciona ela no fim
            remove(posicao);//remove a original
            
        } else if (posicao == this.tamanho){//se for selecionada a posição final
            System.out.println("elemento já se encontra no final");//mostra na tela que a posição já é a desejada           
        } else {//qualquer outra posição
            switch (this.tamanho) {//validação do tamanho do vetor
                case 1://se houver apenas um elemento na lista
                    System.out.println("há apenas um elemento na ltsta");
                    break;
                case 0://se não houver algum elemento na lista
                    throw new IllegalArgumentException("lista vazia");
                default://qualquer outra opção
                    Iterador it = new Iterador(this.inicio);//implementando o iterador
                    int i = 0;
                    while (it.hasNext()){
                        if (i == posicao -1){
                            break;
                        } else {
                            it.next();
                            i++;
                        }
                    }  //definindo as células base       
                    Celula anterior = it.getAtual();//anterior
                    Celula atual = anterior.getProximo();//atual
                    Celula proximo = atual.getProximo();//próxima
                    //ajeitando as posições
                    atual.setProximo(null);//o próximo de atual vira null (levando ela pro final)
                    atual.setAnterior(this.fim);//o anterior da atual vira o antigo fim
                    this.fim.setProximo(atual);//o próximo do fim agora é o atual
                    //com a remoção do atual, o anterior dele se liga com o prócimo
                    anterior.setProximo(proximo);
                    proximo.setAnterior(anterior);
                    break;
            }
        }
    }
}
