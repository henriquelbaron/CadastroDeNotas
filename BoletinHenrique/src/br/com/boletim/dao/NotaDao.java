/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.boletim.dao;

import br.com.boletim.domain.Aluno;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface NotaDao<H> extends BaseDao<H> {

    public boolean deleteNotaAluno(Integer id);

    public List<H> listNotasAluno(Aluno aluno);
}
