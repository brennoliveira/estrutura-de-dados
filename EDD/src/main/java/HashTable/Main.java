/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashTable;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author brenn
 */
public class Main {

    public static void main(String args[]) throws NoSuchAlgorithmException, UnsupportedOperationException, UnsupportedEncodingException{

        /*String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println("Código Hash de s1 ::: " + s1.hashCode()); //HashCode of s1 ::: 99162322
        System.out.println("Código Hash de s2 ::: " + s2.hashCode()); //HashCode of s2 ::: 99162322*/


       String senha = "adminsffsdfdewffawefwehweHKJWEFHKjwefHKJWEFhkjlwefHLKJWEfhlkjssfd";

       MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
       byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

       StringBuilder hexString = new StringBuilder();
       for (byte b : messageDigest) {
         hexString.append(String.format("%02X", 0xFF & b));
       }
       String senhahex = hexString.toString();

       System.out.println(senhahex);
   }

}
