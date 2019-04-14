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
public enum Tipo {
    PROVA(1),
    TRABALHO(2);

    private final Integer id;

    Tipo(Integer cod) {
        this.id = cod;
    }

    public Integer getId() {
        return id;
    }

}
