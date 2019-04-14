/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.boletim.domain;

import br.com.boletim.domain.enums.Tipo;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author ACER
 */
public class Nota implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Tipo tipo;
    private Double notaUm;
    private Double notaDois;
    private Double peso;
    private Aluno aluno;

    public Nota() {
    }

    public Nota(Integer id, Double notaUm, Double notaDois, Double peso) {
        this.id = id;
        this.notaUm = notaUm;
        this.notaDois = notaDois;
        this.peso = peso;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String getTipo() {
        return tipo.toString();
    }

    public void setTipo(String tipo) {
        this.tipo = Enum.valueOf(Tipo.class, tipo);
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getNotaUm() {
        return notaUm;
    }

    public void setNotaUm(Double notaUm) {
        this.notaUm = notaUm;
    }

    public Double getNotaDois() {
        return notaDois;
    }

    public void setNotaDois(Double notaDois) {
        this.notaDois = notaDois;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Nota other = (Nota) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Nota{" + "notaUm=" + notaUm + ", notaDois=" + notaDois + ", peso=" + peso + '}';
    }

}
