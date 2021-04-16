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
public class Main {
 
    public static void main(String[] args) {

        LinkedList lista = new LinkedList();
        
        Aluno a1 = new Aluno("Brenno", 18);
        Aluno a2 = new Aluno("Kevin", 25);
        Aluno a3 = new Aluno("Xico", 19);
        Aluno a4 = new Aluno("Viny", 25);
        Aluno a5 = new Aluno("Rebeca", 19);
        Aluno a6 = new Aluno("Maria", 33);




        lista.addInicio(a1);
        lista.addInicio(a2);
        lista.addInicio(a3);
        lista.addInicio(a4);
        
        lista.addFim(a5);
        
        System.out.println(lista.tamanho());

        a1 = (Aluno) lista.Recupera(0);
        a2 = (Aluno) lista.Recupera(1);
        a3 = (Aluno) lista.Recupera(2);
        a4 = (Aluno) lista.Recupera(3);
        a5 = (Aluno) lista.Recupera(4);

        
        System.out.println(a1.getNome() + a1.getIdade());
        System.out.println(a2.getNome() + a2.getIdade());
        System.out.println(a3.getNome() + a3.getIdade());
        System.out.println(a4.getNome() + a4.getIdade());
        System.out.println(a5.getNome() + a5.getIdade());
    
        
       /* lista.addElemento(a7, 3);
        
        a7 = (Aluno) lista.Recupera(3);
        System.out.println(a7.getNome() + a7.getIdade());
        System.out.println(lista.tamanho());*/
       
       lista.removeInicio();
       
       System.out.println(lista.tamanho());

        a1 = (Aluno) lista.Recupera(0);
        a2 = (Aluno) lista.Recupera(1);
        a3 = (Aluno) lista.Recupera(2);
        a4 = (Aluno) lista.Recupera(3);
        a5 = (Aluno) lista.Recupera(4);

        
        System.out.println(a1.getNome() + a1.getIdade());
        System.out.println(a2.getNome() + a2.getIdade());
        System.out.println(a3.getNome() + a3.getIdade());
        System.out.println(a4.getNome() + a4.getIdade());
        System.out.println(a5.getNome() + a5.getIdade());
    }
    
}
