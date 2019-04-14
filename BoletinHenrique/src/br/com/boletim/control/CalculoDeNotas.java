/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.boletim.control;

import br.com.boletim.domain.Aluno;
import br.com.boletim.domain.Nota;
import br.com.boletim.domain.enums.Situacao;

/**
 *
 * @author ACER
 */
public class CalculoDeNotas {

    public static Aluno setMediaFinal(Aluno a) {
        double mediaNotas;
        double mediaFinal = 0.0;
        for (Nota nota : a.getNotas()) {
            mediaNotas = ((nota.getNotaUm() + nota.getNotaDois()) * nota.getPeso()) / 2;
            mediaFinal += mediaNotas;
        }
        a.setMedia(mediaFinal);
        if (mediaFinal >= 7.0) {
            a.setSituacao(Situacao.APROVADO);
        }
        if (mediaFinal < 7.0 || mediaFinal <= 4.5) {
            a.setSituacao(Situacao.RECUPERAÇÃO);
        }
        if (mediaFinal < 4.5) {
            a.setSituacao(Situacao.REPROVADO);
        }
        return a;
    }
}
