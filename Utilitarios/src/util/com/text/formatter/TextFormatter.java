/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util.com.text.formatter;

import java.text.ParseException;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author hismahil
 */
public class TextFormatter {
    
    private static MaskFormatter formatter;
    
    private TextFormatter(){
        
    }
    
    public static MaskFormatter getDateFormatter(){
        try {
            formatter = new MaskFormatter("##/##/####");
            formatter.setPlaceholderCharacter('_');
            formatter.setValidCharacters("0123456789");
        } catch (ParseException ex) {
            System.err.println("Erro no formato da data");
        }
        return formatter;
    }
    
    public static MaskFormatter getCPFFormatter(){
        try {
            formatter = new MaskFormatter("###.###.###-##");
            formatter.setPlaceholderCharacter('0');
            formatter.setValidCharacters("0123456789");
        } catch (ParseException ex) {
            System.err.println("Erro no formato do CPF");
        }
        return formatter;
    }
    
    public static MaskFormatter getRGFormatter(){
        try {
            formatter = new MaskFormatter("#.###.###-#");
            formatter.setPlaceholderCharacter('0');
            formatter.setValidCharacters("0123456789");
        } catch (ParseException ex) {
            System.err.println("Erro no formato do RG");
        }
        return formatter;
    }
    
    public static MaskFormatter getPhoneFormatter(){
        try {
            formatter = new MaskFormatter("(##)####-####");
            formatter.setPlaceholderCharacter('0');
            formatter.setValidCharacters("0123456789");
        } catch (ParseException ex) {
            System.err.println("Erro no formato da telefone");
        }
        return formatter;
    }
    
    public static MaskFormatter getYearFormatter(){
        try {
            formatter = new MaskFormatter("####");
            formatter.setPlaceholderCharacter('0');
            formatter.setValidCharacters("0123456789");
        } catch (ParseException ex) {
            System.err.println("Erro no formato do ano");
        }
        return formatter;
    }
    
    public static MaskFormatter getCardNumber(){
        try {
            formatter = new MaskFormatter("################");
            formatter.setPlaceholderCharacter('0');
            formatter.setValidCharacters("0123456789");
        } catch (ParseException ex) {
            System.err.println("Erro no formato do número do cartão");
        }
        return formatter;
    }
    
    public static MaskFormatter getMoney(){
        try {
            formatter = new MaskFormatter("###.##");
            formatter.setPlaceholderCharacter('0');
            formatter.setValidCharacters("0123456789.");
        } catch (ParseException ex) {
            System.err.println("Erro no formato do da moeda");
        }
        return formatter;
    }
    
    public static MaskFormatter getNumberFormatter(){
        try {
            formatter = new MaskFormatter("####");
            formatter.setValidCharacters("0123456789");
        } catch (ParseException ex) {
            System.err.println("Erro no formato dos números");
        }
        return formatter;
    }
}
