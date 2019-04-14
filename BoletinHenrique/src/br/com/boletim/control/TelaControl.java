/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.boletim.control;

import br.com.boletim.dao.persistence.PersistenceDao;
import br.com.boletim.domain.Aluno;
import br.com.boletim.domain.enums.Modulo;
import br.com.boletim.domain.Nota;
import br.com.boletim.domain.enums.Situacao;
import br.com.boletim.domain.enums.Tipo;
import br.com.boletim.view.Tela;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ACER
 */
public class TelaControl {

    public Tela tela;
    public static List<JTextField> tfs;
    public static List<JTextField> tfsNotas;
    public Aluno aluno;

    public TelaControl() {
        addTfsOnList();
        addTfNotaOnList();
        for (Modulo value : Modulo.values()) {
            Tela.cbNivel.addItem(value.toString());
        }
    }

    public void salvarAction() {
        if (Validation.checkCampos()) {
            return;
        }

        aluno = new Aluno();
        aluno.setNome(Tela.tfNome.getText());
        aluno.setSobrenome(Tela.tfSobrenome.getText());
        aluno.setMatricula(Tela.tfMatricula.getText());
        aluno.setModulo(Tela.cbNivel.getSelectedItem().toString());

        Nota prova = new Nota();
        prova.setNotaUm(Utils.stringToDouble(Tela.tfNP1.getText()));
        prova.setNotaDois(Utils.stringToDouble(Tela.tfNP2.getText()));
        prova.setPeso(Utils.stringToDouble(Tela.tfPesoProvas.getText()));
        prova.setTipo(Tipo.PROVA);
        prova.setAluno(aluno);
        aluno.addNotas(prova);

        Nota trabalho = new Nota();
        trabalho.setNotaUm(Utils.stringToDouble(Tela.tfT1.getText()));
        trabalho.setNotaDois(Utils.stringToDouble(Tela.tfT2.getText()));
        trabalho.setPeso(Utils.stringToDouble(Tela.tfPesoTrabalhos.getText()));
        trabalho.setTipo(Tipo.TRABALHO);
        trabalho.setAluno(aluno);
        aluno.addNotas(trabalho);

        aluno = CalculoDeNotas.setMediaFinal(aluno);

        if (PersistenceDao.alunoImpl.inserir(aluno)) {
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            setLabels();
        }
    }

    public void toolTipAction(JTextField tf) {
        tf.setToolTipText("Digite entra 0.0 a 1.0");
    }

    public void setLabels() {
        Tela.lblMedia.setText(Utils.formatDouble(aluno.getMedia()));
        Tela.lblSituacao.setText(aluno.getSituacao().toString());
        if (aluno.getSituacao() == Situacao.APROVADO) {
            Tela.lblSituacao.setForeground(new Color(27, 142, 44));
            Tela.lblMedia.setForeground(new Color(27, 142, 44));
        }
        if (aluno.getSituacao() == Situacao.RECUPERAÇÃO) {
            Tela.lblSituacao.setForeground(Color.BLUE);
            Tela.lblMedia.setForeground(Color.BLUE);
        }
        if (aluno.getSituacao() == Situacao.REPROVADO) {
            Tela.lblSituacao.setForeground(Color.RED);
            Tela.lblMedia.setForeground(Color.RED);
        }
    }

    public void addTfsOnList() {
        tfs = new ArrayList<>();
        tfs.add(Tela.tfMatricula);
        tfs.add(Tela.tfNP1);
        tfs.add(Tela.tfNP2);
        tfs.add(Tela.tfNome);
        tfs.add(Tela.tfPesoProvas);
        tfs.add(Tela.tfPesoTrabalhos);
        tfs.add(Tela.tfSobrenome);
        tfs.add(Tela.tfT1);
        tfs.add(Tela.tfT2);
    }

    public void addTfNotaOnList() {
        tfsNotas = new ArrayList<>();
        tfsNotas.add(Tela.tfNP1);
        tfsNotas.add(Tela.tfNP2);
        tfsNotas.add(Tela.tfPesoProvas);
        tfsNotas.add(Tela.tfPesoTrabalhos);
        tfsNotas.add(Tela.tfT1);
        tfsNotas.add(Tela.tfT2);
    }
}
