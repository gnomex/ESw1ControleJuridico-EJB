
package util.com.text.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.com.exception.FaltaDados;
import util.com.exception.SequenciaValorErrado;

/**
 *
 * @author hismahil
 */
public class TextValidator {
    
    private static TextValidator textValidator = null;
    private String value;
    
    private TextValidator(){
        value = null;
    }
    
    public static TextValidator getInstance(){
        if(textValidator == null) textValidator = new TextValidator();
        return textValidator;
    }
    
    public boolean isDate(String value){
        if(value != null && isNumber(value)){
            if(value.charAt(2) == '/' && value.charAt(5) == '/') {
                this.value = value;
                return true;
            }
        }
        return false;
    }
    
    public boolean isPhone(String value){
        if(value != null && isNumber(value) && value.contains("()-")){
            this.value = removeChar(value, '(');
            this.value = removeChar(value, ')');
            this.value = removeChar(value, '-');
            return true;
        }
        
        return false;
    }
    
    private String removeChar(String value,char ch){
        StringBuilder build = new StringBuilder();
        
        for(int i = 0; i < value.length(); i++){
            if(value.charAt(i) == ch) i++;
            build.append(value.charAt(i));
        }
        return build.toString();
    }
    
    public boolean isCPF(String value){
    	
        if(value != null && isNumber(value) && value.contains(".-")){
            this.value = removeChar(value, '.');
            this.value = removeChar(value, '-');
            return true;
        }
        return false;
    }
    
    public boolean isRG(String value){
        if(value != null && isNumber(value) && value.contains(".-")){
            this.value = removeChar(value, '.');
            this.value = removeChar(value, '-');
            return true;
        }
        return false;
    }
    
    public boolean isString(String value){
    	if(value == null || value == ""){
			try {
				throw new FaltaDados("Erro ao testar valor de atributo", "Atributo vazio ou nulo");
			} catch (FaltaDados e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
    	}

		Pattern pattern = Pattern.compile("[0-9]");
		Matcher matcher = pattern.matcher(value);
		if (matcher.find()){
			try {
				throw new SequenciaValorErrado("Erro no atributo de texto",
						"N�o pode haver n�meros");
			} catch (SequenciaValorErrado e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
    	return true;
    }
    
    public boolean isNumber(String value){
    	if(value == null || value == ""){
			try {
				throw new FaltaDados("Erro ao testar valor de atributo", "Atributo vazio ou nulo");
			} catch (FaltaDados e) {
				e.printStackTrace();
			}
			return false;
    	}

		Pattern pattern = Pattern.compile("[a-zA-Z]");
		Matcher matcher = pattern.matcher(value);
		if (matcher.find()) {
			try {
				throw new SequenciaValorErrado("Erro no atributo de n�mero",
						"N�o pode haver letras");
			} catch (SequenciaValorErrado e) {
				e.printStackTrace();
			}
			return false;
		}
		
    	return true;
    }
    
    public String getValue(){
        return value;
    }
}
