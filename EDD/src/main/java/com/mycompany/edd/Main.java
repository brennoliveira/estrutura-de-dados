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
public class Main {
    
    public static void main(String[] args){
        
        //instanciando classe VETOR e informando que ela é do tipo ALUNO
        Vetor<Aluno> vetor = new Vetor<Aluno>(2);
        
        //instanciando os alunos
        Aluno a1 = new Aluno("Brenno", 19);
        Aluno a2 = new Aluno("Kevin", 26);
        
        
        //add o aluno no vetor
        vetor.add(a1);
        vetor.add(a2);
        
        //imprimindo dados do aluno
        System.out.println("Nome: " + vetor.recuperar(0).getNome());
        System.out.println("Idade: " + vetor.recuperar(0).getIdade());
        
        //limpando aluno
        vetor.removerInicio();
        
        System.out.println("Nome: " + vetor.recuperar(0).getNome());
        System.out.println("Idade: " + vetor.recuperar(0).getIdade());
        
    }
    
}
