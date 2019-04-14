/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.boletim.control;

import br.com.boletim.view.Tela;
import java.awt.Color;
import java.text.DecimalFormat;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author ACER
 */
public class Utils {

    private static final DecimalFormat df = new DecimalFormat("#,##0.00");

    public static Double stringToDouble(String d) {
        try {
            return Double.parseDouble(d.replaceAll(",", "."));
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter Doouble " + e.getMessage());
            return 0.0;
        }
    }

    /**
     *
     * @param d
     * @return #,##0.00
     */
    public static String formatDouble(Double d) {
        try {
            return df.format(d);
        } catch (NumberFormatException e) {
            System.out.println("Erro ao Passar Double para String " + e.getMessage());
            return null;
        }
    }

    public static void clearFields() {
        for (JTextField tf : TelaControl.tfs) {
            tf.setText(null);
        }
        Tela.lblMedia.setText("......");
        Tela.lblSituacao.setText("......");
    }

    public static void setRedBorder(JTextField tf) {
        tf.setBorder(new LineBorder(Color.RED));
    }

    public static void setGrayBorder(JTextField tf) {
        tf.setBorder(new LineBorder(Color.gray));
    }
}
