package br.senac.pi3.brawan.service;

import java.math.BigInteger;
import java.security.MessageDigest;


public class Criptografar {
    
    public static String criptografar(String Senha){
        String retorno=""; 
        MessageDigest md; 
        try {
            md = MessageDigest.getInstance("MD5"); 
            BigInteger hash = new BigInteger(1, md.digest(Senha.getBytes()));
            retorno = hash.toString(16); 
        } catch (Exception e) {
        }return retorno;
    }
}
