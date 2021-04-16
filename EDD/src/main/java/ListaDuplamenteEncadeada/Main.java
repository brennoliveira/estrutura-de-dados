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
public class Main {
    
    public static void main(String[] args){
        
        Aluno a1 = new Aluno("Brenno", 18);
        Aluno a2 = new Aluno("Kevin", 25);
        Aluno a3 = new Aluno("Xico", 19);
        Aluno a4 = new Aluno("Viny", 25);
        Aluno a5 = new Aluno("Rebeca", 19);
        Aluno a6 = new Aluno("Maria", 33);
        
        DoublyLinkedList lista = new DoublyLinkedList();
        
        lista.addInicio(a1);
        lista.addInicio(a2);
        lista.addInicio(a3);
        lista.addInicio(a4);
        
        a1 = (Aluno) lista.recupera(0);
        a2 = (Aluno) lista.recupera(1);
        a3 = (Aluno) lista.recupera(2);
        a4 = (Aluno) lista.recupera(3);
       // a5 = (Aluno) lista.recupera(4);
        
        System.out.println(a1.getNome());
        System.out.println(a2.getNome());
        System.out.println(a3.getNome());
        System.out.println(a4.getNome());
        
       
          }
}
