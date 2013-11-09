/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.processo.teste.update;

import br.unioeste.controle.juridico.ejb.ProcessoBeanRemote;
import br.uniotes.controle.juridico.advogado.Advogado;
import br.uniotes.controle.juridico.cliente.Cliente;
import br.uniotes.controle.juridico.forum.Forum;
import br.uniotes.controle.juridico.processo.Processo;
import br.uniotes.controle.juridico.processo.TipoProcesso;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author hismahil
 */
public class Update {
    public static void main(String[] x) throws NamingException, RemoteException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        InitialContext ic = new InitialContext(); 
        
        ProcessoBeanRemote remote = (ProcessoBeanRemote) ic.lookup("java:global/ProcessoEAR/Processo-ejb/ProcessoBean"); 
        
        Processo proc = new Processo();
        proc.setCodProc(2);
        
        proc.setSituacao(1);
        proc.setDescricao("nova situação sendo lançada");
        
        proc = remote.updateProcesso(proc);
    }
}
