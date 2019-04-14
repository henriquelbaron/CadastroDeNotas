/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.boletim.control;

import br.com.boletim.dao.persistence.PersistenceDao;
import br.com.boletim.domain.Aluno;
import br.com.boletim.view.Tela;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ACER
 */
public class Validation {

    public static boolean checkCampos() {
        if (tfEmpty()) {
            JOptionPane.showMessageDialog(null, "Campos obrigatorios", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        if (matriculaExistente()) {
            JOptionPane.showMessageDialog(null, "Matricula ja cadastrada", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        if (camposNumerosComLetras()) {
            JOptionPane.showMessageDialog(null, "Complete os campos corretamente!", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        if (!pesoAceitavel()) {
            JOptionPane.showMessageDialog(null, "A Soma do Peso da Prova e do Trabalho\n Deve ser 1", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        if (notaMaxima()) {
            JOptionPane.showMessageDialog(null, "Nota Invalida!\nNumeros de 0~10, com até Duas casas Decimais", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        return false;
    }

    public static boolean tfEmpty() {
        boolean aux = false;
        for (JTextField tf : TelaControl.tfs) {
            Utils.setGrayBorder(tf);
            if (tf.getText() == null || tf.getText().trim().isEmpty()) {
                Utils.setRedBorder(tf);
                aux = true;
            }
        }
        return aux;
    }

    public static boolean pesoAceitavel() {
        return Utils.stringToDouble(Tela.tfPesoProvas.getText()) + Utils.stringToDouble(Tela.tfPesoTrabalhos.getText()) == 1.0;
    }

    public static boolean notaMaxima() {
        for (JTextField tfsNota : TelaControl.tfsNotas) {
            double d = Utils.stringToDouble(tfsNota.getText());
            if (d > 10.0 || d < 0) {
                Utils.setRedBorder(tfsNota);
                return true;
            }
        }
        return false;
    }

    public static boolean camposNumerosComLetras() {
        for (JTextField tfsNota : TelaControl.tfsNotas) {
            Utils.setGrayBorder(tfsNota);
            String string = tfsNota.getText();
            for (int i = 0; i < string.length(); i++) {
                char ch = string.charAt(i);
                if (!(ch >= '0' && ch <= '9' || ch == '.' || ch == ',')) {
                    Utils.setRedBorder(tfsNota);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean matriculaExistente() {
        Utils.setGrayBorder(Tela.tfMatricula);
        for (Aluno a : PersistenceDao.getAlunoImpl().pesquisarTodos()) {
            if (a.getMatricula().equals(Tela.tfMatricula.getText())) {
                Utils.setRedBorder(Tela.tfMatricula);
                return true;
            }
        }
        return false;
    }
}
