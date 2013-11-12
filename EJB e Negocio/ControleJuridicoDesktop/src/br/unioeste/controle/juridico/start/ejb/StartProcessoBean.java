/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unioeste.controle.juridico.start.ejb;

import br.unioeste.controle.juridico.ejb.ProcessoBeanRemote;
import java.rmi.RemoteException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
/**
 *
 * @author hismahil
 */
public class StartProcessoBean {
    
    private static ProcessoBeanRemote remote;
    
    static{
        InitialContext ic; 
        try {
            ic = new InitialContext();
            remote = (ProcessoBeanRemote) ic.lookup("java:global/ProcessoEAR/Processo-ejb/ProcessoBean"); 
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }
    
    private StartProcessoBean(){}
    
    public static ProcessoBeanRemote getRemote(){
        return remote;
    }
}
