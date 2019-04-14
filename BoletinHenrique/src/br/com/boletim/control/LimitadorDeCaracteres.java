/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.boletim.control;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author ACER
 */
public class LimitadorDeCaracteres extends PlainDocument {

    private int tamanhoMax;

    public LimitadorDeCaracteres(int tamanhoMax) {
        this.tamanhoMax = tamanhoMax;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {

        if (str == null) {
            return;
        }

        String stringAntiga = getText(0, getLength());
        int tamanhoNovo = stringAntiga.length() + str.length();

        if (tamanhoNovo <= tamanhoMax) {
            super.insertString(offset, str, attr);
        } else {
            super.insertString(offset, "", attr);
        }
    }
}
