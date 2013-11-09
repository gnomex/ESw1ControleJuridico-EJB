/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.processo.teste.insert;

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
public class Insert {
    
    public static void main(String[] x) throws NamingException, RemoteException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        InitialContext ic = new InitialContext(); 
        
        ProcessoBeanRemote remote = (ProcessoBeanRemote) ic.lookup("java:global/ProcessoEAR/Processo-ejb/ProcessoBean"); 
        
        Processo proc = new Processo();
        proc.setDtAbertura(sdf.format( new Date( System.currentTimeMillis() ) ));
        proc.setDescricao("sasajaskjaskj");
        proc.setNroProcesso("12345678901");
        proc.setSituacao(0);
        
        Advogado adv = new Advogado();
        adv.setCodAdv(1);
        adv.setNroOAB("22233344455");
        proc.setAdvogado(adv);
        
        Cliente cli = new Cliente();
        cli.setCodCli(1);
        proc.setCliente(cli);
        
        Forum forum = new Forum();
        forum.setCodForum(1);
        proc.setForum(forum);
        
        TipoProcesso tipo = new TipoProcesso();
        tipo.setCodTipoProcesso(1);
        tipo.setTipo("Ação Tributária");
        proc.setTipo(tipo);
        
        proc = remote.insertProcesso(proc);
    }
}
