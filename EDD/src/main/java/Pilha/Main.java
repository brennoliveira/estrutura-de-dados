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
public class Main {
    
    public static void main(String[] args){
        
        Celula a1 = new Celula(5);
        Celula a2 = new Celula(7);
        Celula a3 = new Celula(2);
        Celula a4 = new Celula(1);
        
        Celula a5 = new Celula(9);

        Pilha pilha = new Pilha();

        pilha.push(a1);
        pilha.push(a2);
        pilha.push(a3);
        pilha.push(a4);
        
        a1 = (Celula) pilha.top();
        System.out.println(a1.getElemento());
        
        pilha.pull(a5);
        a1 = (Celula) pilha.top();
        System.out.println(a1.getElemento());
        
        System.out.println(pilha.tamanho());
        
        System.out.println(pilha.isEmpty());
        
        pilha.limpa();
        
        System.out.println(pilha.isEmpty());
        
    }
}
