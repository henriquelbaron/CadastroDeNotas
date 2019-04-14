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
public enum Modulo {

    Básico(1),
    Intermediario(2),
    Avançado(3);

    private final Integer id;

    Modulo(Integer cod) {
        this.id = cod;
    }

    public Integer getId() {
        return id;
    }
}
