/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edd;

/**
 *
 * @author brenn
 */
public class Vetor<T> {
    
    //vetor genérico
    private T[] vetor;
    
    //quantidade de elemntos do vetor
    private int qtdElementos = 0;
    
    //construtor esp. do vetor
    public Vetor(int tam){
        
        //criando um vetor genérico
        vetor = (T[]) new Object[tam];
        
        //nova quantidade de elementos
        this.qtdElementos = tam;
    }
    
    //método que verifica se existe algum dado em uma pos. do vetor
    public boolean existeDado(int pos){
        return vetor[pos] != null;
    }
    
    //método que retorna o valor de uma pos. no vetor
    public T recuperar(int pos){
        //verifica se a posição existe no vetor
        if ((pos < 0 && pos > Tamanho()) || (!existeDado(pos))) {
        throw new ArrayIndexOutOfBoundsException("posição inválida");
    }
        return vetor[pos];
    }
    
    //método que verifica se o vetor é vazio
    public boolean vazio(){
        return Tamanho() == 0;
    }
    
    //método que adiciona elemento no vetor usando ITERADOR
    public void addIterador(T elemento){
        
        if (Tamanho() == vetor.length){
            redimensionar();
        }
        
        //passando o vetor como parâmetro para o ITERADOR
        Iterador it = new Iterador(vetor);
        
        int i = 0;
        //percorrendo o vetor
        while (it.hasNext()){
            if (it.next() == null){
                vetor[i] = elemento;
                qtdElementos++;
                break;
            }
            i++;
        }
    }
    
    //método que add no vetor
    public void add(T elemento){
        //verfica se o vetor está "cheio"
        if (Tamanho() == vetor.length){
            redimensionar();
        }
        //adicionando elemento
        for (int i = 0; i < vetor.length; i++){
            if (vetor[i] == null){
                vetor[i] = elemento;
                qtdElementos++;
                break;
            }
        }
    }
    
    //método que remove elemento de uma posição selecionada
    public void remover(int posicao) throws ArrayIndexOutOfBoundsException{
        
    }
    
    //método que remove no início do vetor
    public void removerInicio(){
        
    }
    
    //método que remove no fim do vetor
    public void removeFim(){
        
        
    }
    
    //método que apaga todas as posições do vetor
    public void limpar(){
        if (qtdElementos == 0){
            System.out.println("Vetor já se encontra vazio");
        } else {
            for (int i = 0; i < vetor.length; i++){
                vetor[i] = null;
                qtdElementos--;
            }
        }
        
    }
    
    //método que retorna o tamanho do vetor
    public int Tamanho(){
        return qtdElementos;
    }
    
    //método que dobra o tamanho do vetor caso ele fique cheio
    public void redimensionar(){
        
    }
}
