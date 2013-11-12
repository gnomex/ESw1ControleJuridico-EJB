/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unioeste.controle.juridico.start.ejb;

import br.unioeste.controle.juridico.ejb.EnderecoBeanRemote;
import java.rmi.RemoteException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
/**
 *
 * @author hismahil
 */
public class StartEnderecoBean {
    
    private static EnderecoBeanRemote remote;
    
    static{
        InitialContext ic; 
        try {
            ic = new InitialContext();
            remote = (EnderecoBeanRemote) ic.lookup("java:global/EnderecoEAR/Endereco-ejb/EnderecoBean"); 
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }
    
    private StartEnderecoBean(){}
    
    public static EnderecoBeanRemote getRemote(){
        return remote;
    }
    
}
