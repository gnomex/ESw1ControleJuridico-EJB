/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util.com.text.msgcap.csv;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/**
 *
 * @author Hismahil Escarvalhar Pereira Dinis
 */
public class CSVWriter {
    private static CSVWriter csvWriter = null;
    private FileWriter fw; //para escrever no arquivo
    private PrintWriter pw; //para usar o println()
    /**
     * <h3>Construtor que inicializa <code><b>fw</b></code> e <code><b>pw</b></code> com null</h3>
     */
    private CSVWriter(){
        fw = null;
        pw = null;
    }
    /**
     * <h3><b>Cria ou retorna instância da classe</b></h3><br/>
     * @return Instância da classe.
     */
    public static CSVWriter getInstance(){
        if(csvWriter == null) csvWriter = new CSVWriter();
        return csvWriter;
    }
    
    /**
     * <h3><b>Cria ou abre arquivo CSV para escrita</b></h3><br/>
     * @param FileName nome do arquivo CSV
     */
    public void createFile(String FileName){
        try {
            fw = new FileWriter(FileName,true);
            pw = new PrintWriter(fw);
        } catch (IOException ex) {
            System.err.println("Não foi possível criar o arquivo!");
        }
    }
    /**
     * <h3><b>Cria ou abre arquivo CSV para escrita</b></h3><br/>
     * @param FileName nome do arquivo CSV
     */
    public void createFile(File FileName){
        try {
            fw = new FileWriter(FileName);
            pw = new PrintWriter(fw);
        } catch (IOException ex) {
            System.err.println("Não foi possível criar o arquivo!");
        }
    }
    
    /**
     * <h3><b>Escreve linha no arquivo CSV</b></h3><br/>
     * @param dados informação gravada e formatada com <code>','</code><br/>
     * separando os dados
     */
    public void writeLine(Object[] dados){
        if(pw != null) {
            String buffer = "";
            for(int i = 0; i < dados.length; i++){
                if(i == dados.length - 1){
                    buffer += dados[i];
                }
                else{
                    buffer += dados[i] + ",";
                }
            }
            pw.println(buffer);
        }
    }
    /**
     * <h3><b>Escreve dados no formato CSV separado por ','</b></h3><br/>
     * @param list Lista com todos os valores a serem escritos
     */
    public void writeAll(List<Object[]> list){
        if(pw != null){
            for(Object[] x: list){
                writeLine(x);
            }
        }
    }
    /**
     * <h3><b>Fecha o arquivo CSV</b></h3>
     */
    public void closeFile(){
        if(pw != null && fw != null){
            try {
                pw.close();
                fw.close();
            } catch (IOException ex) {
                System.err.println("Não foi possível fechar o arquivo!");
            }
        }
    }
}
