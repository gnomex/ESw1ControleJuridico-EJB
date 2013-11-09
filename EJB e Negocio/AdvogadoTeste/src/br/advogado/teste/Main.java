/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.advogado.teste;

import br.unioeste.controle.juridico.ejb.AdvogadoBeanRemote;
import br.uniotes.controle.juridico.advogado.Advogado;
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
        
        AdvogadoBeanRemote remote = (AdvogadoBeanRemote) ic.lookup("java:global/AdvogadoEAR/Advogado-ejb/AdvogadoBean"); 
        
        Advogado adv = remote.obterAdvogado(1);
        
       System.out.println(adv.getNroOAB());
    }
}
