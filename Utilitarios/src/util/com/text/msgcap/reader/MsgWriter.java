/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util.com.text.msgcap.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/**
 *
 * @author Hismahil Escarvalhar Pereira Dinis
 */
public class MsgWriter {
    
    private static MsgWriter msgWriter;
    /**
     * Construtor que apenas coloca null na variavel do FileOutPutStream
     */
    private MsgWriter(){
        
    }
    
    public static MsgWriter getInstance(){
        if(msgWriter == null) msgWriter = new MsgWriter();
        return msgWriter;
    }
    
    /**
     * <h3>Salva mensagens em arquivo XML</h3><br>
     * @param prop Propriedade contendo as mensagens a serem salvas<br>
     * @param descricao Descrição do arquivo de mensagens XML<br>
     * @param fileName Nome do arquivo onde será salvo<br>
     */
    public void writeMessage(Properties prop,String descricao,String fileName){
        FileOutputStream fpout;
        
        try {
            fpout = new FileOutputStream(fileName);
            try {
                prop.storeToXML(fpout, descricao);
                fpout.close();
            } catch (IOException ex) {
                System.err.println("Não foi possível savar dados no arquivo!");
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Não foi possível criar ou abrir o arquivo para escrita!");
        }
    }
    
    /**
     * <h3>Salva mensagens em arquivo XML</h3><br>
     * @param prop Propriedade contendo as mensagens a serem salvas<br>
     * @param descricao Descrição do arquivo de mensagens XML<br>
     * @param fileName Nome do arquivo onde será salvo<br>
     */
    public void writeMessage(Properties prop,String descricao,File fileName){
        FileOutputStream fpout;
        
        try {
            fpout = new FileOutputStream(fileName);
            try {
                prop.storeToXML(fpout, descricao);
                fpout.close();
            } catch (IOException ex) {
                System.err.println("Não foi possível savar dados no arquivo!");
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Não foi possível criar ou abrir o arquivo para escrita!");
        }
    }
    /**
     * <h3>Salva mensagens em arquivo comum</h3><br>
     * @param dados Mensagens a serem salva no arquivo<br>
     * @param fileName Nome do arquivo onde será salvo as mensagens<br>
     */
    public void writeMessage(HashMap dados,String fileName){
        FileOutputStream fpout;
        
        try {
            fpout = new FileOutputStream(fileName);
            PrintStream ps = new PrintStream(fpout);
            
            Set set = dados.keySet();
            Iterator it = set.iterator();
            
            while(it.hasNext()){
                String msg = it.next().toString();
                msg += "="+dados.get(msg);
                ps.println(msg);
            }
            ps.close();
            fpout.close();
        } catch (IOException ex) {
            System.err.println("Não foi possível salvar os dados no arquivo: "+fileName);
        }
    }
}
