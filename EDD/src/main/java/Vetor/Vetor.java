/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vetor;

/**
 *
 * @author brenn
 */
public class Vetor<T> {
    
    //vetor genérico
    private T[] vetor;
    
    //quantidade de elementos do vetor
    private int qtdElementos = 0;
    
    //construtor esp. do vetor
    public Vetor(int qtdElementos){
        
        //novo objeto genérico
        vetor = (T[]) new Object[qtdElementos];
    }
    //tamanho do vetor
    public int tamanho(){
        return qtdElementos;
    }
    
    //verificar se o vetor é vazio
    public boolean vazio(T[] vetor){
        return tamanho() == 0;
    }
    
    //existe dado em alguma posição do vetor
    public boolean existeDado(int posicao){
        return vetor[posicao] != null;
    }
    
    //retorna valor de uma posicção do vetor
    public T recuperar(int posicao){
        //verificar se o vetor é vazio
        if (vazio(vetor)){
            throw new ArrayIndexOutOfBoundsException("vetor vazio");
        }
        //verificar se a posição existe
        if (posicao < 0 && posicao > tamanho()){
            throw new ArrayIndexOutOfBoundsException("posição inválida");
        }
        //verificar se existe dado na posição
        if (!existeDado(posicao)){
            throw new ArrayIndexOutOfBoundsException("posição vazia");
        }
        return vetor[posicao];
    }
    
    //add elemento no INÍCIO do vetor
    public void addInicio(T elemento){
        //verificar se o vetor está cheio
        if (tamanho() >= vetor.length -1){
            redimensionar(vetor);
        }
        //implementando ITERADOR
        Iterador it = new Iterador(vetor);
        int i = 0;
        T inicio = vetor[0];
        T aux = inicio;
        while (it.hasNext()){
            //verificar se I é uma posição válida na lista OU se I é nulo
            if (i < tamanho() && vetor[i] != null){
                //verificar se a posicação é nula
                if (vetor[i + 1] == null){
                    //organizando os dados para inserir
                    aux = vetor[i + 1];
                    vetor[i + 1] = inicio;
                    break;
                }
                //organizando os dados para inserir
                aux = vetor[i + 1];
                vetor[i+ 1] = inicio;
                inicio = aux;
            } else {
                break;
            }
            i++;
        }
        //add elemento
        vetor[0] = elemento;
        qtdElementos++;
    }
    
    //add elemento no FINAL do vetor
    public void addFim(T elemento){
        //verificar se o vetor está cheio
        if (tamanho() >= vetor.length -1){
            redimensionar(vetor);
        }
        //implementando o iterador
        Iterador it = new Iterador(vetor);
        int i = 0;
        //aux de cont
        int tamanho = tamanho();
        while (it.hasNext()){
            //verificar se existe dado OU se o vetor está zerado
            if (!existeDado(i) && tamanho == 0){
                //add elemento
                vetor[i] = elemento;
                qtdElementos++;
                break;
            //se existir dado   
            } else if (existeDado(i)){
                tamanho--;
            }
            i++;
        }
    }
    
    //add elemento em qualquer posição
    public void addElemento(T elemento, int posicao){
        //verificar se o vetor está cheio
        if (tamanho() >= vetor.length -1){
            redimensionar(vetor);
        }
        //verificar se a posição existe
        if (posicao < 0 && posicao > vetor.length){
            throw new ArrayIndexOutOfBoundsException("posição inválida");
        }
        //verificar se é a PRIMEIRA posição
        if (posicao == 0){
            addInicio(elemento);
        }
        //verificar se é a ÚLTIMA posição
        if (posicao == vetor.length -1){
            addFim(elemento);
        }
        //implementar o ITERADOR
        Iterador it = new Iterador(vetor);
        int i = 0;
        int cont = 0;
        T inicio = vetor[0];
        T aux = inicio;
        //se não tiver elemnento na posição
        if (!existeDado(posicao)){
            vetor[posicao] = elemento;
            qtdElementos++;
        //se existir
        } else if (existeDado(posicao)){
            while (it.hasNext()){
                //verificar se a posição é válida
                if (cont >= posicao && cont <= tamanho()){
                    //se o prox for nulo
                    if (vetor[i + 1] == null){
                        aux = vetor[i + 1];
                        vetor[i + 1] = inicio;
                        break;
                    }
                    aux = vetor[i + 1];
                    vetor[i + 1] = inicio;
                    inicio = aux;
                }
                //incrementação
                i++;
                cont++;
            }
            //add elemento
            vetor[posicao] = elemento;
            qtdElementos++;
        }
        
    }
    
    //remover do INÍCIO
    public void removerInicio(){
        //verificar se o vetor é vazio
        if (vazio(vetor)){
            throw new ArrayIndexOutOfBoundsException("vetor vazio");
        }
        //implementar o iterador
        Iterador it = new Iterador(vetor);
        int i = 0;
        while (it.hasNext()){
            //verificar se I é válida
            if (i < tamanho()){
                //voltando cada elemento uma casa
                vetor[i] = vetor[i + 1];
            } else {
                qtdElementos--;
                break;
            }
            //incrementando
            i++;
        }
    }
    
    //remover do FIM
    public void removerFim(){
    //verificar se o vetor é vazio    
    if (vazio(vetor)) {
        throw new ArrayIndexOutOfBoundsException("Vazio");
    }
        //implementar o iterador
        Iterador it = new Iterador(vetor);
        int i = 0;
        int cont = tamanho();
        while (it.hasNext()) {
            //achando o último elemento
            if (cont == 1) {
                vetor[i] = null;
                break;
            } else if (existeDado(i)) {
                cont--;
            }
            i++;
        }
        //decrementação
        qtdElementos--;

    }
    
    //remover de qualquer posição do vetor
    public void removerElemento(int posicao){
        //verificar se o vetor é vazio
        if (vazio(vetor)){
            throw new ArrayIndexOutOfBoundsException("vetor vazio");
        }
        //verificar se a posição é válida
        if (posicao < 0 && posicao > tamanho()){
            throw new ArrayIndexOutOfBoundsException("posição inválida");
        }
        //verificar se a posição possui dado
        if (!existeDado(posicao)){
            throw new ArrayIndexOutOfBoundsException("posição não possui elemento");
        }
        //implementar o iterador
        Iterador it = new Iterador(vetor);
        int i = 0;
        while (it.hasNext()){
            //excluindo elemento
            if (i >= vetor.length -1){
                vetor[i] = null;
                break;
            }
            //realocando os elementos
            if (i >= posicao){
                vetor[i] = vetor[i + 1];
            }
            i++;
        }
        qtdElementos--;
    }
    
    //limpar todos os elementos do vetor
    public void limpar(){
        //verificar se o vetor é vazio
        if (!vazio(vetor)){
            //implementar o iterador
            Iterador it = new Iterador(vetor);
            int i = 0;
            while (it.hasNext()){
                //verificar se I ainda é válido
                if (i > vetor.length -1){
                    break;
                //limpando a lista
                } else {
                    vetor[i] = null;
                }
                //incrementando
                i++;
            }
            qtdElementos++;
        }
    }
    
    //redimensionar lista
    public void redimensionar(T[] vetor){
        //criando vetor auxiliar com o dobro de elementos
        T[] vetorAux = (T[]) new Object[(tamanho() + 1) * 2];
        //passando os elementos de um vetor para o outro
        for (int i = 0; i <= tamanho(); i++){
            vetorAux[i] = vetor[i];
        }
        this.vetor = vetorAux;
    }
    
    
}
