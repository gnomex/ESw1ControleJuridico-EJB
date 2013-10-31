/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util.com.text.msgcap.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hismahil Escarvalhar Pereira Dinis
 */
public class CSVReader {
    private static CSVReader csvReader = null;
    private FileReader fr; //para ler dados do arquivo
    private BufferedReader br; //para readline()
    
    /**
     * <h3>Construtor que só inicializa com <code>null</code> <code><b>fr</b></code> e <code><b>br</b></code></h3>
     */
    private CSVReader(){
        fr = null;
        br = null;
    }
    /**
     * <h3><b>Cria ou retorna instância da classe</b></h3><br/>
     * @return Instância da classe.
     */
    public static CSVReader getInstance(){
        if(csvReader == null) csvReader = new CSVReader();
        return csvReader;
    }
    /**
     * <h3><b>Abre o arquivo CSV para leitura</b></h3><br/>
     * @param FileName nome do arquivo CSV
     */
    public void openFile(String FileName){
        try {
            fr = new FileReader(FileName);
            br = new BufferedReader(fr);
        } catch (FileNotFoundException ex) {
            System.err.println("Não foi possível abrir o arquivo!");
        }
    }
    
    /**
     * <h3><b>Abre o arquivo CSV para leitura</b></h3><br/>
     * @param FileName nome do arquivo CSV
     */
    public void openFile(File FileName){
        try {
            fr = new FileReader(FileName);
            br = new BufferedReader(fr);
        } catch (FileNotFoundException ex) {
            System.err.println("Não foi possível abrir o arquivo!");
        }
    }
    /**
     * <h3><b>Lê linha do arquivo CSV e quebra ele em um vetor de Strings</b></h3><br/>
     * @return Vetor de String
     */
    public String[] readLine(){
        String buffer[], line = null;
        
        if(br != null){
            try {
                line = br.readLine();
            } catch (IOException ex) {
                System.err.println("Não foi possível ler o arquivo!");
            }
            if(line == null) return null;            
        }
        else{
            return null;
        }
        //verifica se é vírgula ou ponto e vírgula
        if(line.contains(";"))
            buffer = line.split(";");
        else
            buffer = line.split(",");
        return buffer;
    }
    /**
     * <h3><b>Lê todos os dados do arquivo CSV</b></h3><br/>
     * @return <code>List</code> de vetor de <code>String</code>
     */
    public List readAll(){
        List buffer = null;
        
        if(br != null){
            buffer = new ArrayList<String[]>();
            String str[];
            
            while( (str = readLine()) != null){
                buffer.add(str);
            }
        }
        
        return buffer;
    }
    /**
     * <h3><b>Fecha o arquivo CSV</b></h3>
     */
    public void closeFile(){
        try {
            br.close();
            fr.close();
        } catch (IOException ex) {
            System.err.println("Não foi possível fechar o arquivo!");
        }
    }
}
