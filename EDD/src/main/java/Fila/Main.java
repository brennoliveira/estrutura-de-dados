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
public class Main {
    
    public static void main(String[] args){
        
        Fila fila = new Fila();
        
        Celula a1 = new Celula("Brenno");
        Celula a2 = new Celula("Viny");
        Celula a3 = new Celula("Kevin");
        Celula a4 = new Celula("Xico");
        Celula a5 = new Celula("Gabriel");
        
        Celula a6 = new Celula("Anderson");
        
        fila.inserir(a1);
        fila.inserir(a2);
        fila.inserir(a3);
        fila.inserir(a4);
        fila.inserir(a5);
        
        System.out.println(fila.tamanho());
        
        a1 = (Celula) fila.getPrimeiro();
        a2 = (Celula) fila.getUltimo();
        
        //primeiro e último
        System.out.println(a1.getElemento() + " e " + a2.getElemento());
        
        
        fila.alterar(a6);
        a1 = (Celula) fila.getPrimeiro();
        System.out.println(a1.getElemento() + " e " + a2.getElemento());
        
        System.out.println(fila.isEmpty());
        fila.limpar();
        System.out.println(fila.isEmpty());
    }
    
    
}
