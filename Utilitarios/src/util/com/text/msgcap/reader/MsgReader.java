
package util.com.text.msgcap.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

/**
 *
 * @author Hismahil Escarvalhar Pereira Dinis
 */
public class MsgReader {

    private static MsgReader msgReader = null;
    
    private MsgReader(){
        
    }
    /**
     * <h3><b>Cria ou retorna instância da classe</b></h3><br/>
     * @return <code>MsgReader</code> instância.
     */
    public static MsgReader getInstance(){
        if(msgReader == null) msgReader = new MsgReader();
        return msgReader;
    }
    /**
     * <h3><b>Lê mensagens do arquivo</b></h3><br/>
     * @param FileName nome do arquivo de mensagens<br/>
     * @param splitWith com separadores <strong>{-:,.=/\|;}</strong> para key e value<br/>
     * @return retorna um hashmap com os keys e values<br/>
     * @throws FileNotFoundException<br/>
     * @throws IOException 
     */
    public HashMap readMessage(String FileName,String splitWith){
        
        HashMap msg = new HashMap<String,String>();
        FileReader fp;
        BufferedReader br;
        String msgText;
        
        try {
            fp = new FileReader(FileName);
            br = new BufferedReader(fp);
            
            try {
                while( (msgText = br.readLine()) != null){
                    String msgVet[] = msgText.split(splitWith);

                    msg.put(msgVet[0], msgVet[1]);
                }
                
                br.close();
                fp.close();
            } catch (IOException ex) {
                System.err.println("Não foi possível ler dados do arquivo!");
            }
            
        } catch (FileNotFoundException ex) {
            System.err.println("Não foi possível achar o arquivo!");
        }
            
        return msg;
    }

    /**
     * <h3><strong>Lê mensagens do arquivo <code>XML<code></strong></h3><br/>
     * @param xmlFile nome do arquivo <code>XML<code><br/>
     * @return Propriedades do arquivo de mensagens condificada em <code>XML<code><br/>
     */
    public Properties readMessage(String xmlFile){
        Properties prop = null;
        
        try {
            FileInputStream fpin = new FileInputStream(xmlFile);
            try {
                prop = new Properties();
                prop.loadFromXML(fpin);
                fpin.close();
                
            } catch (IOException ex) {
                System.err.println("Erro ao ler do arquivo xml: "+xmlFile);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Arquivo não encontrado: "+xmlFile);
        }
        return prop;
    }
    
    /**
     * <h3><strong>Lê mensagens do arquivo <code>XML<code></strong></h3><br/>
     * @param xmlFile nome do arquivo <code>XML<code><br/>
     * @return Propriedades do arquivo de mensagens condificada em <code>XML<code><br/>
     */
    public Properties readMessage(File xmlFile){
        Properties prop = null;
        
        try {
            FileInputStream fpin = new FileInputStream(xmlFile);
            try {
                prop = new Properties();
                prop.loadFromXML(fpin);
                fpin.close();
                
            } catch (IOException ex) {
                System.err.println("Erro ao ler do arquivo xml: "+xmlFile);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Arquivo não encontrado: "+xmlFile);
        }
        return prop;
    }
}
