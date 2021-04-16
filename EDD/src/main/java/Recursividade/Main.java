/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursividade;

/**
 *
 * @author brenn
 */
public class Main {
    
    public static void main(String[] args){
        
        /*System.out.println("início");
        System.out.println(elevarRec(3,4));
        System.out.println("fim");*/
    }
    
    
    static int elevarRec(int k, int n){
        
        if (n == 0){
            return 1;
        } else {
            return k * elevarRec(k, n-1);
        }
    }
    
    
    
}
