/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.endereco.teste;

import br.dados.endereco.Endereco;
import br.unioeste.controle.juridico.ejb.EnderecoBeanRemote;
import java.rmi.RemoteException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author hismahil
 */
public class Main {
    public static void main(String[] args) throws NamingException, RemoteException { 
        InitialContext ic = new InitialContext(); 
        
        EnderecoBeanRemote end = (EnderecoBeanRemote) ic.lookup("java:global/EnderecoEAR/Endereco-ejb/EnderecoBean"); 
        
        Endereco e = end.obterEnderecoPorID(1);
        
        System.out.println(e.getCEP());
    }
}
