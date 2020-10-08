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
        LinkedList<Aluno> listaE = new LinkedList<Aluno>(6);
        
        
        //Instanciando um aluno
        Aluno a = new Aluno("ANA", 30);
        Aluno a2 = new Aluno("MARIA", 35);
        Aluno a3 = new Aluno("CHICAO", 19);
        Aluno a4 = new Aluno("VINYJ", 26);
        Aluno a5 = new Aluno("BRENNIN", 18);
        
        listaE.addElemento(a5, 1);
        listaE.addFim(a);
        listaE.addFim(a2);
        listaE.addFim(a3);
        
        System.out.println(listaE.tamanho());
        
        for (int i = 1; i < listaE.tamanho(); i++) {
            System.out.println(listaE.Recupera(i).getNome());
        }
    }
		
	
}
