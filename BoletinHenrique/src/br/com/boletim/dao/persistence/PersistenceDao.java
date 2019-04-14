/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.boletim.dao.persistence;

import br.com.boletim.dao.impl.AlunoImpl;
import br.com.boletim.dao.impl.NotaImpl;

/**
 *
 * @author ACER
 */
public class PersistenceDao {

    public static AlunoImpl alunoImpl = new AlunoImpl();
    public static NotaImpl notaImpl = new NotaImpl();

    public static AlunoImpl getAlunoImpl() {
        return alunoImpl;
    }

    public static NotaImpl getNotaImpl() {
        return notaImpl;
    }

}
