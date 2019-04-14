/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.boletim.domain.enums;

/**
 *
 * @author ACER
 */
public enum Situacao {

    APROVADO(1),
    RECUPERAÇÃO(2),
    REPROVADO(3);

    private final Integer id;

    Situacao(Integer cod) {
        this.id = cod;
    }

    public Integer getId() {
        return id;
    }
}
