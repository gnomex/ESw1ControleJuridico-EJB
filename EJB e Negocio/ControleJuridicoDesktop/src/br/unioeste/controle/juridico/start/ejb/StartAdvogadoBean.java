/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unioeste.controle.juridico.start.ejb;

import br.unioeste.controle.juridico.ejb.AdvogadoBeanRemote;
import java.rmi.RemoteException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
/**
 *
 * @author hismahil
 */
public class StartAdvogadoBean {
    
    private static AdvogadoBeanRemote remote;
    
    static{
        InitialContext ic; 
        try {
            ic = new InitialContext();
            remote = (AdvogadoBeanRemote) ic.lookup("java:global/AdvogadoEAR/Advogado-ejb/AdvogadoBean"); 
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }
    
    private StartAdvogadoBean(){}
    
    public static AdvogadoBeanRemote getRemote(){
        return remote;
    }
}
