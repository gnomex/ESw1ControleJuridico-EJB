/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util.com.text.length;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * Exemplo em: http://www.guj.com.br/articles/29
 * Esta classe foi feita seguindo o exemplo da guj
 * com algumas modificações
 * @author hismahil
 */
public class TextLength extends PlainDocument{
    
    private int size;
    
    public TextLength(int length){
        this.size = length;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if(str != null && size > 0){
            if( (getLength() + str.length()) <= size){
                super.insertString(offs, str, a);
            }
            else{
                if(getLength() == size) return;
                super.insertString(offs, new String(str.substring(0, size - getLength())), a);
            }
        }
        return;
    }

}
