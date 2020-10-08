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
public class Main {
    
    public static void main(String[] args) {

        /*Instanciando a classe genérica Vetor e nesse momento informando
		que ela é do tipo Aluno*/
        Vetor<Aluno> vetor = new Vetor<Aluno>(5);

        //Instanciando um aluno
        Aluno a1 = new Aluno("ANA", 30);
        Aluno a2 = new Aluno("MARIA", 35);
        Aluno a3 = new Aluno("CHICO", 19);
        Aluno a4 = new Aluno("VINY", 26);
        Aluno a5 = new Aluno("BRENNO", 18);

        //Adicionando o aluno no vetor
        vetor.addElemento(a5, 1);
        vetor.addFim(a1);
        vetor.addFim(a2);
        vetor.addFim(a3);

        //Printando o tamanho do vetor
        System.out.println(vetor.tamanho());

        //Recuperar elemento
        for (int i = 1; i < vetor.tamanho(); i++) {
            System.out.println(vetor.recuperar(i).getNome());
        }
        System.out.println("");

        vetor.addInicio(a4);
        for (int i = 0; i < vetor.tamanho(); i++) {
            System.out.println(vetor.recuperar(i).getNome());
        }
        System.out.println("");
        vetor.removerFim();
        vetor.removerInicio();

        for (int i = 0; i < vetor.tamanho(); i++) {
            System.out.println(vetor.recuperar(i).getNome());
        }
        System.out.println(vetor.tamanho());
        
        vetor.removerElemento(1);
        
       for (int i = 0; i < vetor.tamanho(); i++) {
            System.out.println(vetor.recuperar(i).getNome());
        }
    }
    
}
